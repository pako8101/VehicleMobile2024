package Vehiclemobile2024.service.impl;

import Vehiclemobile2024.model.UserLoginDTO;
import Vehiclemobile2024.model.UserRegistrationDTO;
import Vehiclemobile2024.model.entity.UserEntity;
import Vehiclemobile2024.model.repository.UserRepository;
import Vehiclemobile2024.service.CurrentUser;
import Vehiclemobile2024.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    public UserServiceImpl(CurrentUser currentUser, ModelMapper modelMapper, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) {

        userRepository.save(map(userRegistrationDTO));


    }

    @Override
    public boolean login(UserLoginDTO userLoginDTO) {
        UserEntity userEntity =
                userRepository.findByEmail(userLoginDTO.email())
                        .orElse(null);

        if (userLoginDTO.password() == null ||
                userEntity == null
        || userEntity.getPassword() ==null) {
            return false;
        }

        boolean success =
                passwordEncoder.matches(userLoginDTO
                        .password(), userEntity.getPassword());

        if (success){
            currentUser.setLoggedIn(true);
            currentUser.setFullName(userEntity.getFirstName()
                    + " " + userEntity.getLastName());
        }else {
            currentUser.clean();
        }
        return false;
    }

    private UserEntity map(UserRegistrationDTO userRegistrationDTO) {
        UserEntity mappedEntity = modelMapper.map(userRegistrationDTO, UserEntity.class);

        mappedEntity.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));

        return mappedEntity;
    }
}
