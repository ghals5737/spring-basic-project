package com.company;

public class Main {

    public static void main(String[] args) {
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        //Base 64 encoding
        IEncoder encoder=new Base64Encoder();
        String result= encoder.encode(url);

        //UTF-8 encoding
        IEncoder urlEncoder =new UrlEncoder();
        String urlResult= urlEncoder.encode(url);

        System.out.println(result);
        System.out.println(urlResult);
    }
}
