package com.spring.Ecommerce.infrastructure.controllers.Users;

import com.spring.Ecommerce.infrastructure.persistence.Users;
import com.spring.Ecommerce.infrastructure.services.UserDeleteImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ap1/v1/users")
public class UserDeleteController {
    private final UserDeleteImp deleteImp;

    @Autowired
    public UserDeleteController(UserDeleteImp deleteImp) {
        this.deleteImp = deleteImp;
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id) {
        this.deleteImp.execute(id);
    }
}
