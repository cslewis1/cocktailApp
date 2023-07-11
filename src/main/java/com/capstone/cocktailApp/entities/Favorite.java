package com.capstone.cocktailApp.entities;

import com.capstone.cocktailApp.dtos.FavoriteDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Favorites")
@Data
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long favorite_id;

    @Column
    private String notes;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private User user;

    public Favorite(FavoriteDto favoriteDto) {
    }

 //    @ManyToMany(mappedBy = "favorites", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})

    @ManyToMany
    @JoinTable(name="favorite_cocktail",
            joinColumns = @JoinColumn(name = "favorite_id"),
            inverseJoinColumns = @JoinColumn(name = "cocktail_id"))
    private Set<Cocktail> cocktails = new HashSet<>();

    public Long getFavoriteID() {
        return favorite_id;
    }

    public void setFavoriteID(Long favoriteID) { this.favorite_id = favorite_id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Favorite() {
    }

    public Favorite(Long favoriteID, String notes) {
        this.favorite_id = favoriteID;
        this.notes = notes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Cocktail> getCocktails() {
        return cocktails;
    }


    public void setCocktail(Cocktail cocktail) {
    }
}
