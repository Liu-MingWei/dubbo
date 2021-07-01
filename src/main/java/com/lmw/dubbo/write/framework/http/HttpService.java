package com.lmw.dubbo.write.framework.http;

import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;


/**
 * 用来启动一个内嵌的Tomcat
 * 可以写一个配置文件来选择启动Tomcat还是Jetty
 *
 * @author liumingwei
 * @date 2021/6/13
 */
public class HttpService {


    public void start(String hostName, Integer post) {
        // 创建tomcat服务器
        Tomcat tomcatServer = new Tomcat();

        Server server = tomcatServer.getServer();
        Service service = server.findService("Tomcat");
        Connector connector = new Connector();
        connector.setPort(post);

        Engine engine = new StandardEngine();
        engine.setDefaultHost(hostName);

        Host host = new StandardHost();
        host.setName(hostName);

        String contextPath = "";
        Context context = new StandardContext();
        context.setPath(contextPath);
        context.addLifecycleListener(new Tomcat.FixContextListener());

        host.addChild(context);
        engine.addChild(host);

        service.setContainer(engine);
        service.addConnector(connector);

        // /*说明所有的请求 都会交给DispatcherServlet去处理
        tomcatServer.addServlet(contextPath,"dispatcher", new DispatcherServlet());
        context.addServletMappingDecoded("/*","dispatcher");

        try {
            tomcatServer.start();
            tomcatServer.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }

    }
}
