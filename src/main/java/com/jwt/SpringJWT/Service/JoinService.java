package com.jwt.SpringJWT.Service;

import com.jwt.SpringJWT.Domain.RoleType;
import com.jwt.SpringJWT.Domain.User;
import com.jwt.SpringJWT.Dto.UserDto.*;
import com.jwt.SpringJWT.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor    // 생성자 자동 생성 어노테이션
public class JoinService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    // 원래는 성공여부에 따라 boolean값을 리턴
    public boolean joinProcess(JoinDto request) {
        String username = request.getUsername();
        String password = request.getPassword();

        Boolean isExist = userRepository.existsByUsername(username);
        if (isExist) {
            return false;
        }
        User data = new User();
        data.setUsername(username);
        data.setPassword(bCryptPasswordEncoder.encode(password));   // password는 암호화해서 저장!
        data.setRole(RoleType.ADMIN);
        userRepository.save(data);
        return true;
    }
}
