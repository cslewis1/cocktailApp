package com.capstone.cocktailApp.services;

import com.capstone.cocktailApp.dtos.CocktailDto;

import java.util.List;
import java.util.Optional;

public interface CocktailService {
    List<CocktailDto> getAllCocktailsByUserId(Long userId);

    void addCocktail(CocktailDto cocktailDto, Long userId);

    void deleteCocktailById(Long cocktailId);

    void updateCocktailById(CocktailDto cocktailDto);

    Optional<CocktailDto> getCocktailById(Long cocktailId);
}
