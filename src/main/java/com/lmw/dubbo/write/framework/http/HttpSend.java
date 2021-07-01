package com.lmw.dubbo.write.framework.http;

import com.alibaba.fastjson.JSONObject;
import com.lmw.dubbo.write.framework.dto.Invocation;


import org.apache.commons.httpclient.methods.PostMethod;

import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import java.io.IOException;


/**
 * 请求发送类 dubbo源码使用的是netty框架实现的
 * 可通过配置读取选用哪种HttpClient工具类
 *
 * @author liumingwei
 * @date 2021/6/13
 */
public class HttpSend {
    public String send(String hostName, Integer port, Invocation invocation) throws IOException {

        org.apache.commons.httpclient.HttpClient httpClient = new org.apache.commons.httpclient.HttpClient();

        // 创建post请求方法实例对象
        PostMethod postMethod = new PostMethod("http://" + hostName + ":" + port);
        RequestEntity param = new StringRequestEntity(JSONObject.toJSONString(invocation), "application/json", "UTF-8");
        postMethod.setRequestEntity(param);

        // 设置post请求超时时间
        postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 60000);
        postMethod.addRequestHeader("Content-Type", "application/json");
        httpClient.executeMethod(postMethod);

        String result = postMethod.getResponseBodyAsString();
        postMethod.releaseConnection();
        return result;

    }
}
