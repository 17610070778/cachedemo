package com.xlauncher.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author: create by 王亚奇
 * @version: v1.0
 * @description: com.xlauncher.entity
 * @date:2019/2/14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Size(min = 1, max = 5)
    private String name;
    @NotNull
    @Size(min = 1, max = 1)
    private String sex;
    @NotNull
    @Size(min = 1, max = 2)
    private String age;
}
