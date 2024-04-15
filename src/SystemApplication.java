package com.youth.system;

import com.youth.system.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SystemApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(SystemApplication.class, args);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
