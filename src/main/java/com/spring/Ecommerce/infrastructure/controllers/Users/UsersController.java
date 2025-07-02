package com.spring.Ecommerce.infrastructure.controllers.Users;

import com.spring.Ecommerce.core.entities.User;
import com.spring.Ecommerce.infrastructure.dto.UpdateUserDTO;
import com.spring.Ecommerce.infrastructure.dto.UsersEntityDTO;
import com.spring.Ecommerce.infrastructure.mapper.UserEntityMapper;
import com.spring.Ecommerce.infrastructure.services.User.*;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ap1/v1/users")
public class UsersController {

    private final UserCreateImp userCreateImp;
    private final FindUserByDocumentImp findUserByDocumentImp;
    private final FindUserByEmailImp findUserByEmailImp;
    private final GetAllUsersImp getAllUsersImp;
    private final UserUpdateImp userUpdateImp;

    private final UserEntityMapper userEntityMapper;

    @Autowired
    public UsersController(UserCreateImp userCreateImp, FindUserByDocumentImp findUserByDocumentImp, FindUserByEmailImp findUserByEmailImp, GetAllUsersImp getAllUsersImp, UserUpdateImp userUpdateImp, UserEntityMapper userEntityMapper) {
        this.userCreateImp = userCreateImp;
        this.findUserByDocumentImp = findUserByDocumentImp;
        this.findUserByEmailImp = findUserByEmailImp;
        this.getAllUsersImp = getAllUsersImp;
        this.userUpdateImp = userUpdateImp;
        this.userEntityMapper = userEntityMapper;
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody UsersEntityDTO userEntityDTO) {
        User recieveUser = this.userEntityMapper.usersEntity(userEntityDTO);
        User savedUser = this.userCreateImp.execute(recieveUser);
        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/find/byDocument/{document}")
    public ResponseEntity<User> findUserByDocument(@PathVariable String document) {
        return new ResponseEntity<User>(this.findUserByDocumentImp.execute(document), HttpStatus.FOUND);
    }

    @GetMapping("/find/byEmail/{email}")
    public ResponseEntity<User> findUserByEmail(@PathVariable String email) {
        return new ResponseEntity<User>(this.findUserByEmailImp.execute(email), HttpStatus.FOUND);
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<List<User>>(this.getAllUsersImp.execute(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@RequestBody UpdateUserDTO updateUserDTO, @PathVariable long id){
        User receiverUserToUpdate = this.userEntityMapper.mapUserToUpdatedUserDomain(updateUserDTO);
        var savedUserUpdated = this.userUpdateImp.execute(receiverUserToUpdate, id);
        return new ResponseEntity<User>(savedUserUpdated, HttpStatus.OK);
    }

}
