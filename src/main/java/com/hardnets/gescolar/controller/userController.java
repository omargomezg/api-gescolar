package com.hardnets.gescolar.controller;

import com.hardnets.gescolar.domain.UserModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class userController {

    @GetMapping("/user")
    List<UserModel> allUsers() {
        List<UserModel> list = new ArrayList<UserModel>();
        list.add(new UserModel(23, "Descripcion uno"));
        list.add(new UserModel(24, "Descripcion dos"));

        return list;
    }

    @GetMapping("/user/{username}/{password}")
    UserModel one(@PathVariable int username, @PathVariable String password) {
        UserModel userModel = new UserModel(23, "Descripcion de un solo registro");
        return userModel;
    }

    @PostMapping("/user")
    UserModel newUser(@RequestBody UserModel data) {
        data.id = data.id + 23;
        return data;
    }

    @PutMapping("user/{id}")
    UserModel updateModel(@RequestBody UserModel data, @PathVariable int id){
        return data;
    }

    @DeleteMapping("user/{id}")
    boolean deteleItem(@PathVariable int id){
        return id == 1 ? true: false;
    }

}
