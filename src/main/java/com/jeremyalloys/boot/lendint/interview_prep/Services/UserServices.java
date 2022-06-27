package com.jeremyalloys.boot.lendint.interview_prep.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeremyalloys.boot.lendint.interview_prep.Models.User;
import com.jeremyalloys.boot.lendint.interview_prep.Repos.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// I used this Service as a way to perform actions on my DB. Modulerizing stuff
// helps me visualize things better. Maybe it'll help you too. 
@Service
public class UserServices {
    private UserRepository userRepository;

    @Autowired
    public UserServices(UserRepository userRepository){
        super();
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        this.userRepository.findAll().forEach(users::add);
        return users;
    }

    public Optional<User> findUserById(Long user_id){
        return this.userRepository.findById(user_id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    
}
