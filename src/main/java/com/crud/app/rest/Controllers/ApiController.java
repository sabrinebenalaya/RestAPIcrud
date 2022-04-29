package com.crud.app.rest.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @GetMapping(value = "/")
    public String getPage(){
        return"welcome to restful API CRUD";
    }

}
