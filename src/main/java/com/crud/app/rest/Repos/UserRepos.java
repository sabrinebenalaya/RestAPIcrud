package com.crud.app.rest.Repos;

import java.util.List;

import com.crud.app.rest.Models.User;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepos extends JpaRepository<User, Long>{
    List<User> findByFirstName(String firstName);
    List<User> findByLastName(String lastName);
    List<User> findByOccupation(String occupation);
    List<User> findByAge(int age);
    List<User> findByFirstNameAndLastName(String firstName,String lastName);
    default void updatUser(User userFromDb,User user){
        if (!(user.getFirstname()==null)){userFromDb.setFirstname(user.getFirstname());}  
        if (!(user.getLastName()==null)){userFromDb.setLastName(user.getLastName());}
        if(user.getAge()!=0){userFromDb.setAge(user.getAge());}
        if (!(user.getOccupation()==null)){userFromDb.setOccupation(user.getOccupation());}
       
 }
}
