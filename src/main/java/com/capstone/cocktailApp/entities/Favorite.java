package com.capstone.cocktailApp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "Favorites")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long favoriteID;

    @Column(unique = true)
    private Long cocktailID;

    @Column
    private Long userID;

    @Column
    private String notes;

    @ManyToOne
    @JsonBackReference
    private User user;

    @ManyToOne
    @JsonBackReference
    private Cocktail cocktail;

    public Long getFavoriteID() {
        return favoriteID;
    }

    public void setFavoriteID(Long favoriteID) {
        this.favoriteID = favoriteID;
    }

    public Long getCocktailID() {
        return cocktailID;
    }

    public void setCocktailID(Long cocktailID) {
        this.cocktailID = cocktailID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Favorite() {
    }

    public Favorite(Long favoriteID, Long cocktailID, Long userID, String notes) {
        this.favoriteID = favoriteID;
        this.cocktailID = cocktailID;
        this.userID = userID;
        this.notes = notes;
    }
}
