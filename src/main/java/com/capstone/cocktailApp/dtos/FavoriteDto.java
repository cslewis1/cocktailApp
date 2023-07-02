package com.capstone.cocktailApp.dtos;

import com.capstone.cocktailApp.entities.Favorite;

public class FavoriteDto {
    private Long favoriteID;
    private Long cocktailID;
    private Long userID;
    private String notes;

    public FavoriteDto(Favorite favorite){
        if(favorite.getFavoriteID() != null){
            this.favoriteID = favorite.getFavoriteID();
        }
        if(favorite.getCocktailID() != null){
            this.cocktailID = favorite.getCocktailID();
        }
        if(favorite.getUserID() != null){
            this.userID = favorite.getUserID();
        }
        if(favorite.getNotes() != null){
            this.notes = favorite.getNotes();
        }
    }
}
