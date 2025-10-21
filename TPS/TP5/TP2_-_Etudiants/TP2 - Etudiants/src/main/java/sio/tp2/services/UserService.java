package sio.tp2.services;

import org.springframework.stereotype.Service;
import sio.tp2.entities.User;
import sio.tp2.repositories.UserRepository;

import java.util.List;

@Service
public class UserService
{
    public UserRepository userRepository;
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public List<User> findAll()
    {
        return userRepository.findAll();
    }
    public User getByLoginAndPwdUser(String loginUser, String pwd)
    {
        return userRepository.findByLoginUserAndPwdUser(loginUser,pwd).get(0);
    }
}
