package com.capstone.cocktailApp.dtos;

import com.capstone.cocktailApp.entities.Cocktail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CocktailDto implements Serializable {
    private Long cocktail_id;
    private String cocktailName;
    private String ingredients;
    private String glassType;
    private String directions;
    private String imgURL;
    private FavoriteDto favoriteDto;
    private UserDto userDto;

    public CocktailDto(Cocktail cocktail){
        if(cocktail.getCocktailID() != null){
            this.cocktail_id = cocktail.getCocktailID();
        }
        if(cocktail.getCocktailName() != null){
            this.cocktailName = cocktail.getCocktailName();
        }
        if(cocktail.getIngredients() != null){
            this.ingredients = cocktail.getIngredients();
        }
        if(cocktail.getGlassType() != null){
            this.glassType = cocktail.getGlassType();
        }
        if(cocktail.getDirections() != null){
            this.directions = cocktail.getDirections();
        }
        if(cocktail.getImgURL() != null){
            this.imgURL = cocktail.getImgURL();
        }
    }

    public Long getCocktailID() {
        return cocktail_id;
    }
}
