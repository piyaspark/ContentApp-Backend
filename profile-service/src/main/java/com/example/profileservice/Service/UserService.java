package com.example.profileservice.Service;

import com.example.profileservice.Model.User;
import com.example.profileservice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllProfiles(){
        return (List<User>) userRepository.findAll();
    }

    public Optional<User> findProfileById(Long id){
        return userRepository.findById(id);
    }

    public Optional<User> findProfileByUsername(String username){
        return userRepository.findUserByUsername(username);
    }

    public User addProfile(User profile){
        profile.setId(null);
        return userRepository.save(profile);
    }

    public Optional<User> updateProfile(Long id, User profile){
        Optional<User> contentOptional = userRepository.findById(id);
        if(!contentOptional.isPresent()){
            return contentOptional;
        }
        profile.setId(id);
        return Optional.of(userRepository.save(profile));
    }

    public Boolean deleteProfile(Long id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch (EmptyResultDataAccessException e){
            return false;
        }
    }

}
