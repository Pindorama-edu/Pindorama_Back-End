package pindorama.database.services;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pindorama.database.User;
import pindorama.database.repos.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    @Getter
    private UserRepository repository;

    public List<User> getAllUsers() {
        return new ArrayList<>(repository.findAll());
    }

    public User getUserByEmail(String email) {
        for (var user : repository.findAll()) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }


    //Just use that if are register new user
    public void createUser(User user) {
        repository.save(user);
    }

    public void insertPicture(User user){
       repository.save(user);
    }
}
