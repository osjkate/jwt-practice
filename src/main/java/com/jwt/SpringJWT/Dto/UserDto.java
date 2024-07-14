package com.jwt.SpringJWT.Dto;

import lombok.Getter;
import lombok.Setter;

public class UserDto {
    @Setter @Getter
    public static class JoinDto{
        private String username;
        private String password;
    }
}
