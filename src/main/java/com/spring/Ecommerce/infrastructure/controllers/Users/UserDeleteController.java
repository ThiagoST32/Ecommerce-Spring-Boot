package com.spring.Ecommerce.infrastructure.controllers.Users;

import com.spring.Ecommerce.infrastructure.Repositories.UserEntityRepository;
import com.spring.Ecommerce.infrastructure.services.User.UserDeleteImp;
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
    private final UserEntityRepository entityRepository;

    @Autowired
    public UserDeleteController(UserDeleteImp deleteImp, UserEntityRepository entityRepository) {
        this.deleteImp = deleteImp;
        this.entityRepository = entityRepository;
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        if (this.entityRepository.existsById(id)){
            this.deleteImp.execute(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
