package mk.ukim.finki.lab1.service.application;

import mk.ukim.finki.lab1.dto.CreateUserDto;
import mk.ukim.finki.lab1.dto.DisplayUserDto;
import mk.ukim.finki.lab1.dto.LoginResponseDto;
import mk.ukim.finki.lab1.dto.LoginUserDto;

import java.util.Optional;

public interface UserApplicationService {
    Optional<DisplayUserDto> register(CreateUserDto createUserDto);

    Optional<LoginResponseDto> login(LoginUserDto loginUserDto);

    Optional<DisplayUserDto> findByUsername(String username);
}