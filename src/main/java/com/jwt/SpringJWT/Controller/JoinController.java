package com.jwt.SpringJWT.Controller;

import com.jwt.SpringJWT.Dto.UserDto.*;
import com.jwt.SpringJWT.Service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JoinController {

    private final JoinService joinService;

    @PostMapping("/join")
    public String joinProcess(
            @RequestBody JoinDto request) {

        if (joinService.joinProcess(request)) {
            return "ok";
        } else return " 404 error";
    }
}
