package pindorama.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers(){
        ArrayList<User> users = new ArrayList<>();
        repository.findAll().forEach(users::add);
        return users;
    }

    public User getUserByEmail(String email){
        for(var user : repository.findAll()){
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }

    public void setNewSession(String sessionId){
    }


    //Just use that if are register new user
    public void createUser(User user){
        repository.save(user);
    }
}
