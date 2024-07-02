package Vehiclemobile2024.service;

import Vehiclemobile2024.model.UserLoginDTO;
import Vehiclemobile2024.model.UserRegistrationDTO;

public interface UserService {

    void registerUser(UserRegistrationDTO userRegistrationDTO);

    boolean login(UserLoginDTO userLoginDTO);

    void logout();
}
