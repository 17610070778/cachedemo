package com.xlauncher.service;

import com.xlauncher.commont.Result;
import com.xlauncher.entity.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author: create by 王亚奇
 * @version: v1.0
 * @description: com.xlauncher.service
 * @date:2019/2/14
 */
public interface StudentService {
    Flux<Student> findALl();

    Mono<Result> addStudent(Student student);
}
