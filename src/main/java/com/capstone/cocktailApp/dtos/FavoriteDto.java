package com.capstone.cocktailApp.dtos;

import com.capstone.cocktailApp.entities.Favorite;

import java.util.HashSet;
import java.util.Set;

public class FavoriteDto {
    private Long favorite_id;
    private String notes;
    private UserDto userDto;
    private Set<CocktailDto> cocktailDtoSet = new HashSet<>();

    public FavoriteDto(Favorite favorite){
        if(favorite.getFavoriteID() != null){
            this.favorite_id = favorite.getFavoriteID();
        }
        if(favorite.getNotes() != null){
            this.notes = favorite.getNotes();
        }
    }
}
