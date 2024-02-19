package com.TrashTwoCash.trash_two_cash.service;

import com.TrashTwoCash.trash_two_cash.dto.UserDTO;
import com.TrashTwoCash.trash_two_cash.repo.UserRepo;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

   public UserDTO saveUser(UserDTO userDTO){
       userRepo.save(modelMapper.map(userDTO, org.apache.catalina.User.class));
       return userDTO;
   }
    public List<UserDTO> getAllUsers(){
        List<org.apache.catalina.User> userList=userRepo.findAll();
        return modelMapper.map(userList,new TypeToken<List<UserDTO>>(){}.getType());
    }
    public UserDTO updateUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }
}
