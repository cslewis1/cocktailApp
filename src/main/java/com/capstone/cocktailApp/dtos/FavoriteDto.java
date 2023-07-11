package com.capstone.cocktailApp.dtos;

import com.capstone.cocktailApp.entities.Favorite;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteDto implements Serializable {
    private Long favorite_id;
    private String notes;
    private UserDto userDto;
    private CocktailDto cocktailDto;
    private Set<CocktailDto> cocktailDtoSet = new HashSet<>();

    public FavoriteDto(Favorite favorite){
        if(favorite.getFavoriteID() != null){
            this.favorite_id = favorite.getFavoriteID();
        }
        if(favorite.getNotes() != null){
            this.notes = favorite.getNotes();
        }
    }

    public Long getFavoriteID() {
        return favorite_id;
    }

}
