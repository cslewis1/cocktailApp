package com.capstone.cocktailApp.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Cocktails")
public class Cocktail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cocktailID;

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

    @OneToMany(mappedBy = "cocktail", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonManagedReference
    private Set<Favorite> favoriteSetCocktail = new HashSet<>();


    public Long getCocktailID() {
        return cocktailID;
    }

    public void setCocktailID(Long cocktailID) {
        this.cocktailID = cocktailID;
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
        this.cocktailID = cocktailID;
        this.cocktailName = cocktailName;
        this.ingredients = ingredients;
        this.glassType = glassType;
        this.directions = directions;
        this.imgURL = imgURL;
    }
}
