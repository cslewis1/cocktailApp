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
    private Long userID;
    private String username;
    private String password;
    private Set<FavoriteDto> favoriteUserDtoSet = new HashSet<>();

    public UserDto(User user){
        if(user.getUserID() != null){
            this.userID = user.getUserID();
        }
        if(user.getUsername() != null){
            this.username = user.getUsername();
        }
        if(user.getPassword() != null){
            this.password = user.getPassword();
        }
    }
}
