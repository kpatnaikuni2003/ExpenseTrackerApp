package com.kafka.userservice.service;

import com.kafka.userservice.entities.UserInfo;
import com.kafka.userservice.entities.UserInfoDto;
import com.kafka.userservice.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

@Service
public class UserService {

    @Autowired
    private  UserRepository userRepository;

    public UserInfoDto createOrUpdateUser(UserInfoDto userInfoDto){

        //functional interface
        UnaryOperator<UserInfo> updatingUser = user -> {
            user.setFirstName(userInfoDto.getFirstName());
            user.setLastName(userInfoDto.getLastName());
            user.setEmail(userInfoDto.getEmail());
            user.setPhoneNumber(userInfoDto.getPhoneNumber());
            user.setProfilePic(userInfoDto.getProfilePic());
            user.setUserId(userInfoDto.getUserId());
            return userRepository.save(user);
        };

        //functional interface
        Supplier<UserInfo> createUser = () -> {
            return userRepository.save(userInfoDto.transformToUserInfo());
        };

        UserInfo userInfo = userRepository.findByUserId(userInfoDto.getUserId())
                .map(updatingUser)
                .orElseGet(createUser);
        return new UserInfoDto(
                userInfo.getUserId(),
                userInfo.getFirstName(),
                userInfo.getLastName(),
                userInfo.getPhoneNumber(),
                userInfo.getEmail(),
                userInfo.getProfilePic()
        );
    }

    public UserInfoDto getUser(UserInfoDto userInfoDto) throws Exception{
        Optional<UserInfo> userInfoDtoOpt = userRepository.findByUserId(userInfoDto.getUserId());
        if(userInfoDtoOpt.isEmpty()){
            throw new Exception("User not found");
        }
        UserInfo userInfo = userInfoDtoOpt.get();
        return new UserInfoDto(
                userInfo.getUserId(),
                userInfo.getFirstName(),
                userInfo.getLastName(),
                userInfo.getPhoneNumber(),
                userInfo.getEmail(),
                userInfo.getProfilePic()
        );
    }
}
