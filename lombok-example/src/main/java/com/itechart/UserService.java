package com.itechart;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Log
//@Log4j
//@Slf4j
public class UserService {

    public void createUser(UserDtoV1 userDto) {
        log.info("creating user with name " + userDto.getName());
    }

    public void deleteUser(Long userId) {
        log.info("deleting user with id " + userId);
    }

}
