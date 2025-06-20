package com.spring.Ecommerce.infrastructure.controllers.Users;

import com.spring.Ecommerce.core.entities.User;
import com.spring.Ecommerce.infrastructure.dto.UsersEntityDTO;
import com.spring.Ecommerce.infrastructure.mapper.UserEntityMapper;
import com.spring.Ecommerce.infrastructure.services.FindUserByDocumentImp;
import com.spring.Ecommerce.infrastructure.services.UserCreateImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ap1/v1/users")
public class UsersController {

    private final UserCreateImp userCreateImp;
    private final FindUserByDocumentImp findUserByDocumentImp;
    private final UserEntityMapper userEntityMapper;

    @Autowired
    public UsersController(UserCreateImp userCreateImp, FindUserByDocumentImp findUserByDocumentImp, UserEntityMapper userEntityMapper) {
        this.userCreateImp = userCreateImp;
        this.findUserByDocumentImp = findUserByDocumentImp;
        this.userEntityMapper = userEntityMapper;
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody UsersEntityDTO userEntityDTO) {
        User recieveUser = this.userEntityMapper.usersEntity(userEntityDTO);
        User savedUser = this.userCreateImp.execute(recieveUser);
        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/find/{document}")
    public ResponseEntity<User> findUserByDocument(@PathVariable String document) {
        return new ResponseEntity<User>(this.findUserByDocumentImp.execute(document), HttpStatus.FOUND);
    }

}
