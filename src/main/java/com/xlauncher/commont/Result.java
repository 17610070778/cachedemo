package com.xlauncher.commont;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回结果
 * @author: create by 王亚奇
 * @version: v1.0
 * @description: com.xlauncher.commont
 * @date:2019/2/14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private boolean flag;
    private String message;
}
