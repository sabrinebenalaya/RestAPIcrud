package com.crud.app.rest.Controllers;

import java.util.List;


import com.crud.app.rest.Models.User;
import com.crud.app.rest.Repos.UserRepos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserRepos userrepos;

    //affichier tous les users
    @GetMapping(path = "/all")
    public @ResponseBody Iterable < User > getAllUsers() {
        return userrepos.findAll();
    }

    //ajouter un user
    @PostMapping(path = "/add")
    public @ResponseBody String addNewUser(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String occupation,
            @RequestParam int age) {

        User user = new User();
        user.setFirstname(firstName);
        user.setLastName(lastName);
        user.setAge(age);
        user.setOccupation(occupation);
        userrepos.save(user);
        return "User Created";
    }

    //update  user
    @PostMapping(path = "/update/{id}")
    public @ResponseBody String updateUser(@RequestParam long id){
     userrepos.deleteById(id);
     return "user deleted";
    }
        
    //delete  user
    @PostMapping(path = "/delete/{id}")
    public User deleteUser(@RequestParam int id, @RequestParam User user){
    return userrepos.updateUserById(id,user);
    }

    //trouver un user par son id
    @GetMapping(path = "/id")
    public User getUserById (@RequestParam long id){
                   return userrepos.findById(id);   
    }

    //trouver un user par son occupation
    @GetMapping(path = "/occupation")
    public ResponseEntity<List<User>> getUserByOccupation(@RequestParam String occupation ){
        return new ResponseEntity<List<User>>(userrepos.findByOccupation(occupation), HttpStatus.OK);
    }

    //trouver un user par son age
    @GetMapping(path = "/age")
    public ResponseEntity<List<User>> getUserByAge(@RequestParam int age ){
        return new ResponseEntity<List<User>>(userrepos.findByAge(age), HttpStatus.OK);
    }

    //trouver un user par son prenom
    @GetMapping(path = "/firstName")
    public ResponseEntity<List<User>>  getUserByFirstName(@RequestParam String firstName ){
        return new ResponseEntity<List<User>>(userrepos.findByFirstName(firstName), HttpStatus.OK);
    }
    
    //trouver un user par son nom
    @GetMapping(path = "/lastName")
    public ResponseEntity<List<User>>  getUserByLastName(@RequestParam String lastName ){
        return new ResponseEntity<List<User>>(userrepos.findByLastName(lastName), HttpStatus.OK);
    }
    
    //trouver un user par son nom et prenom
    @GetMapping(path = "/name")
    public ResponseEntity<List<User>>  getUserByFirstName(@RequestParam String firstName, @RequestParam String lastName ){
        return new ResponseEntity<List<User>>(userrepos.findByFirstNameANDLastName(firstName,lastName), HttpStatus.OK);
    }

  
    
}
