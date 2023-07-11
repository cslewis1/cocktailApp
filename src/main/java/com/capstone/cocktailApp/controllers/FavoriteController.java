package com.capstone.cocktailApp.controllers;


import com.capstone.cocktailApp.dtos.CocktailDto;
import com.capstone.cocktailApp.dtos.FavoriteDto;
import com.capstone.cocktailApp.services.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/favorites")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

    @PostMapping("user/{userId}/cocktail/{cocktailId}")
    public void addCocktailToFavorites(@RequestBody FavoriteDto favoriteDto, @PathVariable Long userId, @PathVariable Long cocktailId) {
        favoriteService.addCocktailToFavorites(favoriteDto, userId, cocktailId);
    }

    @DeleteMapping("/{favoriteId}")
    public void deleteFavoriteById(@PathVariable Long favoriteId){
        favoriteService.deleteFavoriteById(favoriteId);
    }

    @PutMapping
    public void updateFavorite(FavoriteDto favoriteDto){
        favoriteService.updateFavorite(favoriteDto);
    }

    @GetMapping("/{favoriteId}")
    public Optional<FavoriteDto> getFavoriteById(@PathVariable Long favoriteId){
        return favoriteService.getFavoriteById(favoriteId);
    }

    @GetMapping("/allFavorites")
    public List<FavoriteDto> getAllFavorites() {
        return favoriteService.getAllFavorite();
    }
}
