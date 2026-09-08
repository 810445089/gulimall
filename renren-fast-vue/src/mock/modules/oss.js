/*
 * @Author: WangGuojian 1085844536@qq.com
 * @Date: 2024-02-03 22:21:08
 * @LastEditTime: 2024-02-24 23:10:43
 * @LastEditors: WangGuojian 1085844536@qq.com
 * @FilePath: \htmld:\Developer\WGJ\Java_WorkSpace\guli\gulimall\renren-fast-vue\src\mock\modules\oss.js
 * @Description:
 */
import Mock from "mockjs";

// 生成数据列表
var dataList = [];
for (let i = 0; i < Math.floor(Math.random() * 10 + 1); i++) {
  dataList.push(
    Mock.mock({
      id: "@increment",
      url:
        'http://oapk0ekso.bkt.clouddn.com/upload/@date("yyyyMMdd")/@guid().png',
      createDate: "@datetime"
    })
  );
}

// 获取文件列表
export function list() {
  return {
    // isOpen: false,
    url: "/sys/oss/list",
    type: "get",
    data: {
      msg: "success",
      code: 0,
      page: {
        totalCount: dataList.length,
        pageSize: 10,
        totalPage: 1,
        currPage: 1,
        list: dataList
      }
    }
  };
}

// 获取云存储配置信息
export function config() {
  return {
    // isOpen: false,
    url: "/sys/oss/config",
    type: "get",
    data: {
      msg: "success",
      code: 0,
      config: {
        type: 1,
        qiniuDomain: "http:// oapk0ekso.bkt.clouddn.com",
        qiniuPrefix: "upload",
        qiniuAccessKey: "2fIEkyYuNXatF4HIXlMbUY6dA-rDQpuADPxtnAHZ",
        qiniuSecretKey: "G4F9gqYRJd5K56pDGaWQrGIzV8me4rT7mQQUKfmk",
        qiniuBucketName: "xiaolu-vido",
        aliyunDomain: "",
        aliyunPrefix: "",
        aliyunEndPoint: "",
        aliyunAccessKeyId: "",
        aliyunAccessKeySecret: "",
        aliyunBucketName: "",
        qcloudDomain: "",
        qcloudPrefix: "",
        qcloudAppId: null,
        qcloudSecretId: "",
        qcloudSecretKey: "",
        qcloudBucketName: "",
        qcloudRegion: null
      }
    }
  };
}

// 保存云存储配置信息
export function addConfig() {
  return {
    // isOpen: false,
    url: "/sys/oss/saveConfig",
    type: "post",
    data: {
      msg: "success",
      code: 0
    }
  };
}

// 删除文件
export function del() {
  return {
    // isOpen: false,
    url: "/sys/oss/delete",
    type: "post",
    data: {
      msg: "success",
      code: 0
    }
  };
}
