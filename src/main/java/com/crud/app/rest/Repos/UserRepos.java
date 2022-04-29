package com.crud.app.rest.Repos;

import java.util.List;

import com.crud.app.rest.Models.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepos extends JpaRepository<User, Long>{
    User findById(long id);
    List<User> findByFirstName(String firstName);
    List<User> findByLastName(String lastName);
    List<User> findByOccupation(String occupation);
    List<User> findByAge(int age);
    List<User> findByFirstNameANDLastName(String firstName,String lastName);
    
    public default User updateUserById(int id, User user){
        User UserUpdate = findById(id);
        UserUpdate.setFirstname(user.getFirstname());
        UserUpdate.setLastName(user.getLastName());
        UserUpdate.setAge(user.getAge());
        UserUpdate.setOccupation(user.getOccupation());
        return save(UserUpdate);
    }

  

}
