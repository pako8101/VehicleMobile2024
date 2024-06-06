package Vehiclemobile2024.service.impl;

import Vehiclemobile2024.model.UserRegistrationDTO;
import Vehiclemobile2024.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


private final ModelMapper modelMapper;
private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) {



    }
}
