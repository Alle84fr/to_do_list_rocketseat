package br.com.afr8799.to_do_list.users;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


public interface IUserRepository extends JpaRepository<UserModel, UUID>{
    // representação dos métodos

    UserModel findByUsername(String username);


}
