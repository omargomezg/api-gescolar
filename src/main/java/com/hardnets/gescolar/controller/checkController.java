package com.hardnets.gescolar.controller;

import com.hardnets.gescolar.domain.UserModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class checkController {

    @GetMapping("/hola")
    List<UserModel> allUsers() {
        List<UserModel> list = new ArrayList<UserModel>();
        list.add(new UserModel(23, "Descripcion uno"));
        list.add(new UserModel(24, "Descripcion dos"));

        return list;
    }

    @GetMapping("/hola/{id}")
    UserModel one(@PathVariable int id) {
        UserModel userModel = new UserModel(23, "Descripcion de un solo registro");
        return userModel;
    }

    @PostMapping("/hola")
    UserModel newUser(@RequestBody UserModel data) {
        data.id = data.id + 23;
        return data;
    }

    @PutMapping("hola/{id}")
    UserModel updateModel(@RequestBody UserModel data, @PathVariable int id) {
        return data;
    }

    @DeleteMapping("hola/{id}")
    boolean deteleItem(@PathVariable int id) {
        return id == 1;
    }

}
