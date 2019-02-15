package com.xlauncher.service.impl;

import com.xlauncher.commont.Result;
import com.xlauncher.entity.Student;
import com.xlauncher.repository.StudentRepository;
import com.xlauncher.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author: create by 王亚奇
 * @version: v1.0
 * @description: com.xlauncher.service.impl
 * @date:2019/2/14
 */
@Service
@Slf4j
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * 查询所有
     * @return
     */
    @Override
    // 由于方法无参数，指定缓存的key时，用类名
    @Cacheable(value = "findAll", key = "target")
    public Flux<Student> findALl() {
        return Flux.fromIterable(studentRepository.findAll());
    }

    /**
     * 添加学生
     * @param student
     * @return
     */
    @Override
    @CacheEvict(value = "findAll", key = "target")
    public Mono<Result> addStudent(Student student) {
        return Mono.just(student)
                .map(studentRepository::save)
                .map(student1 -> new Result(true, "添加成功"));
    }
}
