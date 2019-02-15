package com.xlauncher.controller;

import com.xlauncher.commont.Result;
import com.xlauncher.entity.Student;
import com.xlauncher.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.Objects;

/**
 * @author: create by 王亚奇
 * @version: v1.0
 * @description: com.xlauncher.controller
 * @date:2019/2/14
 */
@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * 查询所有
     */
    @GetMapping("/findAll")
    public Flux<Student> findAll() {
        return studentService.findALl();
    }

    /**
     * 增加
     */
    @PutMapping("/addStudent")
    public Mono<Result> addStudent(@RequestBody @Valid Mono<Student> studentMono) {
        return studentMono
                .flatMap(studentService::addStudent)
                .onErrorResume(error -> {
                    if (error instanceof WebExchangeBindException) {
                        WebExchangeBindException exception = (WebExchangeBindException) error;
                        FieldError fieldError = (FieldError)exception.getAllErrors().get(0);
                        return Mono.just(new Result(false, fieldError.getField() + fieldError.getDefaultMessage() ));
                    }else {
                        return Mono.just(new Result(false, "添加失败"));
                    }
                });
    }
}
