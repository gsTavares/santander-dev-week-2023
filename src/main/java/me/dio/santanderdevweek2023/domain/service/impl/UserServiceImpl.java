package me.dio.santanderdevweek2023.domain.service.impl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.santanderdevweek2023.domain.model.User;
import me.dio.santanderdevweek2023.domain.repository.UserRepository;
import me.dio.santanderdevweek2023.domain.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if(userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account already exists!");
        }
        return userRepository.save(userToCreate);
    }
    
}
