package com.example.demo.service;

import com.example.demo.dto.SignupUserDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.exceptionHandler.UserAlreadyExists;
import com.example.demo.repository.UserRepository;
import com.example.demo.userDetail.MyUserDetails;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user=userRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("User Not Found"));
        return new MyUserDetails(user);
    }

    public UserDto CreateUser(SignupUserDto signupUserDto) {
        User newUser;
        UserDto userDto = null;
        Optional<User> user = userRepository.findByEmail(signupUserDto.getEmail());
        if (!user.isPresent()) {
            newUser = modelMapper.map(signupUserDto, User.class);
            newUser.setActive(true);
            userRepository.save(newUser);
            userDto=modelMapper.map(user,UserDto.class);
        }
        return userDto;
    }

    public MyUserDetails getUser(String email) throws UsernameNotFoundException {
        User user=userRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("User Not Found"));
        return new MyUserDetails(user);
    }
}
