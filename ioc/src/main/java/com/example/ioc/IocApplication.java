package com.example.ioc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class IocApplication {

    public static void main(String[] args) {

        SpringApplication.run(IocApplication.class, args);
        ApplicationContext context=ApplicationContextProvider.getContext();

        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        Encoder urlEncoder = context.getBean("urlEncode", Encoder.class);
        Encoder Base64Encoder = context.getBean("base64Encode", Encoder.class);
        System.out.println(urlEncoder.encode(url));
        System.out.println(Base64Encoder.encode(url));
    }

    @Configuration
    class AppConfig{

        @Bean("base64Encode")
        public Encoder encoder(Base64Encoder base64Encoder){
            return new Encoder(base64Encoder);
        }

        @Bean("urlEncode")
        public Encoder encoder(UrlEncoder urlEncoder){
            return new Encoder(urlEncoder);
        }
    }

}
