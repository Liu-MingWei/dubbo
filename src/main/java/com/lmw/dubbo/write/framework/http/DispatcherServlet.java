package com.lmw.dubbo.write.framework.http;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 用来处理Http请求 get/post等请求接口
 * 在HttpService类里代码配置这个类来处理所有Http请求
 * 一般用来承接请求 具体的Http请求处理实现在HttpServiceHandler类里
 *
 * @author liumingwei
 * @date 2021/6/13
 */
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 通过承接把具体的处理逻辑发送到HttpServiceHandler类里去处理
        new HttpServiceHandler().handler(req,resp);
    }
}
