package com.capstone.cocktailApp.entities;

import com.capstone.cocktailApp.dtos.CocktailDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Cocktails")
public class Cocktail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cocktail_id;

    @Column(unique = true)
    private String cocktailName;
    @Column
    private String ingredients;
    @Column
    private String glassType;
    @Column
    private String directions;
    @Column
    private String imgURL;

    @ManyToOne
    @JsonBackReference
    private Favorite favorite;

    public Cocktail(CocktailDto cocktailDto) {
    }

    public Long getCocktailID() {
        return cocktail_id;
    }

    public void setCocktailID(Long cocktailID) {
        this.cocktail_id = cocktailID;
    }

    public String getCocktailName() {
        return cocktailName;
    }

    public void setCocktailName(String cocktailName) {
        this.cocktailName = cocktailName;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getGlassType() {
        return glassType;
    }

    public void setGlassType(String glassType) {
        this.glassType = glassType;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public Cocktail() {
    }

    public Cocktail(Long cocktailID, String cocktailName, String ingredients, String glassType, String directions, String imgURL) {
        this.cocktail_id = cocktailID;
        this.cocktailName = cocktailName;
        this.ingredients = ingredients;
        this.glassType = glassType;
        this.directions = directions;
        this.imgURL = imgURL;
    }

    public void setUser(User user) {
    }
}
