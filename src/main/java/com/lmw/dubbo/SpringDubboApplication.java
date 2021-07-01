package com.lmw.dubbo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//表示对指定包下的类进行扫描，扫描@Service与@Reference注解，并且进行处理
@EnableDubbo(scanBasePackages = "org.apache.dubbo.demo.provider")
//@PropertySource表示将dubbo-provider.properties中的配置项添加到Spring容器中，可以通过@Value的方式获取到配置项中的值
@PropertySource("classpath:/spring/dubbo-provider.properties")
public class SpringDubboApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDubboApplication.class, args);
    }

}
