package com.xlauncher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author: create by 王亚奇
 * @version: v1.0
 * @description: com.xlauncher
 * @date:2019/2/14
 */
@SpringBootApplication
// 启用缓存
@EnableCaching
public class StudentApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);
    }
}
