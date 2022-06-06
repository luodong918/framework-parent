package com.framework.parent.design.filter;

import lombok.Data;

/**
 * @author luodong
 * @date 2022/6/2
 */
@Data
public class Person {
    private String name;
    private String gender;
    private String maritalStatus;

    public Person(String name, String gender, String maritalStatus) {
        this.name = name;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }
}
