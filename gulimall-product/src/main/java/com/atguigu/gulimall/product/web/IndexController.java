package com.atguigu.gulimall.product.web;

import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;
import com.atguigu.gulimall.product.vo.Catalog2Vo;
import org.redisson.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
public class IndexController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping({ "/", "index.html" })
    public String indexPage(Model model) {

        List<CategoryEntity> categoryEntitys = categoryService.getLevel1Categorys();
        model.addAttribute("categories", categoryEntitys);

        return "index";
    }

    @ResponseBody
    @GetMapping("/index/catalog.json")
    public Map<String, List<Catalog2Vo>> indexCatalog() {
        return categoryService.getCatalogJson2();
    }

    @ResponseBody
    @GetMapping("/hello")
    public String hello() {

        RLock lock = redissonClient.getLock("my-lock");
        /**
         * 1）、锁的自动续续期，如果业务运行时间长，运行期间，锁自动续续期，默认30秒。不用担心过期。
         * 2）、锁的业务只要运行完成，就不会续续期，即使不手动解锁，锁默认在30秒以后自动解锁。
         */
//        lock.lock();
        lock.lock(30, TimeUnit.SECONDS);
//        lock.tryLock(10, 30, TimeUnit.SECONDS); // 尝试加锁，最多等待100秒，超时时间30秒
        try {
            System.out.println("加锁成功,执行业务...");
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }

        return "hello";
    }

    @ResponseBody
    @GetMapping("/write")
    public String write() {
        RReadWriteLock lock = redissonClient.getReadWriteLock("rw-lock");

        RLock rLock = lock.writeLock();

        rLock.lock();
        String s = "";
        try {
            System.out.println("加写锁成功..." + Thread.currentThread().getId());
            Thread.sleep(30000);
            s = UUID.randomUUID().toString();
            stringRedisTemplate.opsForValue().set("writeValue", s);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            rLock.unlock();
            System.out.println("写锁释放..." + Thread.currentThread().getId());
        }

        return s;
    }

    @ResponseBody
    @GetMapping("/read")
    public String read() {
        RReadWriteLock lock = redissonClient.getReadWriteLock("rw-lock");

        RLock rLock = lock.readLock();
        rLock.lock();
        String s = "";
        try {
            System.out.println("加读锁成功..." + Thread.currentThread().getId());
            s = stringRedisTemplate.opsForValue().get("writeValue");
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            rLock.unlock();
            System.out.println("读锁释放..." + Thread.currentThread().getId());
        }

        return s;
    }


    @ResponseBody
    @GetMapping("/lockDoor")
    public String lockDoor() throws InterruptedException {
        RCountDownLatch door = redissonClient.getCountDownLatch("door");

        door.trySetCount(5);
        door.await();

        return "放假了...";
    }

    @ResponseBody
    @GetMapping("/gogogo/{id}")
    public String gogogo(@PathVariable("id") Long id) {
        RCountDownLatch door = redissonClient.getCountDownLatch("door");

        door.countDown();
        return id + "班的人都走了...";
    }

    @ResponseBody
    @GetMapping("/park")
    public String park() throws InterruptedException {
        RSemaphore park = redissonClient.getSemaphore("park");

//        park.acquire(); // 同步获取一个信号，获取一个值

        boolean b = park.tryAcquire();

        if (b) {

        } else {
            return "error";
        }
        return "ok";
    }

    @ResponseBody
    @GetMapping("/go")
    public String go() {
        RSemaphore park = redissonClient.getSemaphore("park");

        park.release();
        return "ok";
    }
}
