package br.com.afr8799.to_do_list.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/")
    public UserModel create (@RequestBody UserModel userModel){

        var user = this.userRepository.findByUsername(userModel.getUsername());

        if(user != null) {
            System.out.println("Já existente");
            return null;
        }

        var userCreated = this.userRepository.save(userModel);
        return userCreated;
    }
}

