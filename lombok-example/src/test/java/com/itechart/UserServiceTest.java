package com.itechart;

import com.itechart.UserDtoV1;
import com.itechart.UserService;
import org.junit.Test;

public class UserServiceTest {

    private final UserService userService = new UserService();

    /**
     * Logging
     */
    @Test
    public void createUserTest() {
        UserDtoV1 userDto = new UserDtoV1();
        userDto.setName("Alex");
        userService.createUser(userDto);
    }


}
