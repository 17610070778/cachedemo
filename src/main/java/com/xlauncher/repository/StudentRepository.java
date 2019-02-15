package com.xlauncher.repository;

import com.xlauncher.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: create by 王亚奇
 * @version: v1.0
 * @description: com.xlauncher.repository
 * @date:2019/2/14
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
