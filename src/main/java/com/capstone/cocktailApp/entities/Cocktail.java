package com.capstone.cocktailApp.entities;

import com.capstone.cocktailApp.dtos.CocktailDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Cocktails")
@Data
public class Cocktail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cocktail_id;

    @Column(length = 300)
    private String cocktailName;

    @Column(length = 2000)
    private String ingredients;

    @Column(length = 300)
    private String glassType;

    @Column(length = 2000)
    private String directions;

    @Column(length = 2000)
    private String imgURL;

    @ManyToOne
    @JsonBackReference
    private User user;

    @ManyToMany(mappedBy = "cocktails", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<Favorite> favorites = new HashSet<>();

    public Cocktail(CocktailDto cocktailDto){
        if(cocktailDto.getCocktailID() != null){
            this.cocktail_id = cocktailDto.getCocktailID();
        }
        if(cocktailDto.getCocktailName() != null){
            this.cocktailName = cocktailDto.getCocktailName();
        }
        if(cocktailDto.getIngredients() != null){
            this.ingredients = cocktailDto.getIngredients();
        }
        if(cocktailDto.getGlassType() != null){
            this.glassType = cocktailDto.getGlassType();
        }
        if(cocktailDto.getDirections() != null){
            this.directions = cocktailDto.getDirections();
        }
        if(cocktailDto.getImgURL() != null){
            this.imgURL = cocktailDto.getImgURL();
        }
    }

    public Long getCocktailID() {
        return cocktail_id;
    }

    public void setCocktailID(Long cocktail_id) {
        this.cocktail_id = cocktail_id;
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
    @Override
    public String toString() {
        return "Cocktail{" +
                "cocktail_id=" + cocktail_id +
                ", cocktailName='" + cocktailName + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", glassType='" + glassType + '\'' +
                ", directions='" + directions + '\'' +
                ", imgURL='" + imgURL + '\'' +
                ", user=" + user +
                ", favorites=" + favorites +
                '}';
    }

    public Cocktail() {
    }

    public Cocktail(Long cocktail_id, String cocktailName, String ingredients, String glassType, String directions, String imgURL) {
        this.cocktail_id = cocktail_id;
        this.cocktailName = cocktailName;
        this.ingredients = ingredients;
        this.glassType = glassType;
        this.directions = directions;
        this.imgURL = imgURL;
    }
}
