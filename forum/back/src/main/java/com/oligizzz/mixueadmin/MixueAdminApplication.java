package com.oligizzz.mixueadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.oligizzz.mixueadmin/mapper")
public class MixueAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(MixueAdminApplication.class, args);
    }

}
