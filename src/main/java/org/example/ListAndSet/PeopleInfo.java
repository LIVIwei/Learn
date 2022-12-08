package org.example.ListAndSet;

/**
 * @Author: LIVI
 * @Time: 2022/11/29  19:08
 * @Description:
 */
import lombok.Data;

/**
 * @author: create by bughuang
 * @version: v1.0
 * @description:
 * @date:2020/3/11
 */
@Data
public class PeopleInfo {
    private int id;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private String age;

    /**
     * 电话
     */
    private String phone;
}
