package service.serviceImpl;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.UserRepo;
import service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo repo;

    @Override
    public void registerUser(User user) {
        repo.save(user);
    }
}
