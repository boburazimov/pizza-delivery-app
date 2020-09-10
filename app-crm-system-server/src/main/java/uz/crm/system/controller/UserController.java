package uz.crm.system.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.crm.system.entity.catalogs.User;
import uz.crm.system.security.CurrentUser;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/userMe")
    public HttpEntity<?> userMe(@CurrentUser User user) {
        return ResponseEntity.ok(user);
    }
}
