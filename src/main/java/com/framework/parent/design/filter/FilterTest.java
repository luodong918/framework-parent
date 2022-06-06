package com.framework.parent.design.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luodong
 * @date 2022/6/2
 */
public class FilterTest {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();

        persons.add(new Person("Robert","Male", "Single"));
        persons.add(new Person("John","Male", "Married"));
        persons.add(new Person("Laura","Female", "Married"));
        persons.add(new Person("Diana","Female", "Single"));
        persons.add(new Person("Mike","Male", "Single"));
        persons.add(new Person("Bobby","Male", "Single"));


    }
}
