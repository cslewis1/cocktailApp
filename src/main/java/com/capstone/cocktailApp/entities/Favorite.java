package com.capstone.cocktailApp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Favorites")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long favorite_id;

    @Column
    private String notes;

    @ManyToOne
    @JsonBackReference
    private User user;

    @OneToMany(mappedBy = "favorite", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonManagedReference
    private Set<Cocktail> cocktailSet = new HashSet<>();

    public Long getFavoriteID() {
        return favorite_id;
    }

    public void setFavoriteID(Long favoriteID) {
        this.favorite_id = favorite_id;
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
}
