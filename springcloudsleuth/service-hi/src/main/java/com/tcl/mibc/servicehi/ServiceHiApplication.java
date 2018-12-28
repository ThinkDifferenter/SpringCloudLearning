package com.tcl.mibc.servicehi;

import brave.sampler.Sampler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication()
@RestController
public class ServiceHiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceHiApplication.class, args);
    }

    private static final Logger LOG = Logger.getLogger(ServiceHiApplication.class.getName());

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    /**
     * 在此调用miya中的方法
     */
    @RequestMapping("/getMiYa")
    public String getHi(){
        LOG.log(Level.INFO, "beginning getMiYa.......");
        return restTemplate.getForObject("http://localhost:8989/info", String.class);
    }

    @RequestMapping("/info")
    public String info(){
        LOG.log(Level.INFO, "service-hi is being called ");
        return "i'm service-hi";
    }

    @RequestMapping("/getMyself")
    public String getMyself(){
        LOG.log(Level.INFO, "beginning getMyself...... ");
        return restTemplate.getForObject("http://localhost:8989/hiSelf", String.class);
    }

//    @Bean
//    public Sampler defaultSampler() {
//        return Sampler.ALWAYS_SAMPLE;
//    }
}

