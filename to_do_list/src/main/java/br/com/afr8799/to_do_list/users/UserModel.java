package br.com.afr8799.to_do_list.users;

import lombok.Data;

@Data
public class UserModel {
    private String username;
    private String name;
    private String password;

}


// para acessar o banco de dados
//localhost:8080/h2-console


