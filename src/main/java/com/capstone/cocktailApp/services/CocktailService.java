package com.capstone.cocktailApp.services;

import com.capstone.cocktailApp.dtos.CocktailDto;
import com.capstone.cocktailApp.entities.Cocktail;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CocktailService {
@Transactional
    void addCocktail(CocktailDto cocktailDto, Long userId);
@Transactional
    void deleteCocktailById(Long cocktailId);

@Transactional
    void updateCocktailById(CocktailDto cocktailDto);

    List<Cocktail> getAllCocktails();

    Optional<CocktailDto> getCocktailById(Long cocktailId);

    List<CocktailDto> getAllCocktailsByUserId(Long userId);

}
