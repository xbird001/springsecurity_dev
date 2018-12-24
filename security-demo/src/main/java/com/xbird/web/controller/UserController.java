package com.xbird.web.controller;

import com.xbird.dto.User;
import com.xbird.exception.UserNotExistException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping
    public User create(@RequestBody User user) {
        logger.info(user.getName());
        logger.info(user.getName());
        logger.info(user.getBirthday().toString());
        user.setId("1");
        return user;
    }

    @ApiOperation(value = "更新用户")
    @PutMapping("/{id:\\d+}")
    public User update(@RequestBody User user,@ApiParam("用户ID") @PathVariable("id") String id) {
        logger.info(id);
        logger.info(user.getName());

        user.setId("1");
        return user;
    }

    @GetMapping("/queryUser")
    public User queryUser(User user) {
        /*throw new UserNotExistException("1");*/
        user.setName("subzhou");
        return user;
    }
}
