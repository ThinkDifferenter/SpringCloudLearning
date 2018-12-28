package com.tcl.mibc.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ClientApplication {

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    /**
     *  多个参数用&符号连接，请求中的参数名称要完全相同
      */
    public String home(@RequestParam String name)
    {
        return "hi " + name + ",i am from port:" + port;
    }

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
        System.out.println("Client Connected.......");
    }
}
