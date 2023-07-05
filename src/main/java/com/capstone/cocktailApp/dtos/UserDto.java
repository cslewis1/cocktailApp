package com.capstone.cocktailApp.dtos;

import com.capstone.cocktailApp.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private Long user_id;
    private String username;
    private String password;
    private Set<FavoriteDto> favoriteDtoSet = new HashSet<>();


    public UserDto(User user){
        if(user.getUserID() != null){
            this.user_id = user.getUserID();
        }
        if(user.getUsername() != null){
            this.username = user.getUsername();
        }
        if(user.getPassword() != null){
            this.password = user.getPassword();
        }
    }
}
