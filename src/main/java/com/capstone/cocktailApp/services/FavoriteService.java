package com.capstone.cocktailApp.services;

import com.capstone.cocktailApp.dtos.CocktailDto;
import com.capstone.cocktailApp.dtos.FavoriteDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface FavoriteService {
    @Transactional
    void addCocktailToFavorites(FavoriteDto favoriteDto, Long userId, Long cocktailId);

    @Transactional
    void deleteFavoriteById(Long favoriteId);

    @Transactional
    void updateFavorite(FavoriteDto favoriteDto);

    Optional<FavoriteDto> getFavoriteById(Long favoriteId);

    List<FavoriteDto> getAllFavorite();

//    List<CocktailDto> getAllFavoritesByUserId(Long userId);
}
