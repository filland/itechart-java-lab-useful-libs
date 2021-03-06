package com.itechart;

import org.junit.Test;

public class UserDtoTest {
    /**
     * getters/setters and toString() method
     */
    @Test
    public void test1() {
        UserDtoV1 v1 = new UserDtoV1();
        v1.setId(1L);
        v1.setName("Alex");
        v1.setLastName("K");
        v1.setAge(20);
        System.out.println(v1.toString());

        UserDtoV2 v2 = new UserDtoV2();
        v2.setId(2L);
        v2.setName("John");
        v2.setLastName("Smith");
        v2.setAge(30);
        System.out.println(v2.toString());
    }

    /**
     * constructors
     */
    @Test
    public void test2() {
        UserDtoV1 v1 = new UserDtoV1(1L, "Alex", "K", 20);
        System.out.println(v1.toString());

        // constructor with all arguments was generated by Lombok
        UserDtoV2 v2 = new UserDtoV2(2L, "John", "Smith", 30);
        System.out.println(v2.toString());
    }
}