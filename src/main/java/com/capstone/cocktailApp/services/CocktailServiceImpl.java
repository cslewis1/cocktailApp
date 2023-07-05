package com.capstone.cocktailApp.services;

import com.capstone.cocktailApp.dtos.CocktailDto;
import com.capstone.cocktailApp.entities.Cocktail;
import com.capstone.cocktailApp.entities.User;
import com.capstone.cocktailApp.repositories.CocktailRepository;
import com.capstone.cocktailApp.repositories.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CocktailServiceImpl {
    @Autowired
    private FavoriteRepository favoriteRepository;
    @Autowired
    private CocktailRepository cocktailRepository;

    @Transactional
    public void addCocktail(CocktailDto cocktailDto){
        Cocktail cocktail = new Cocktail(cocktailDto);
        cocktailRepository.saveAndFlush(cocktail);
    }

    @Transactional
    public void deleteCocktailbyId(Long cocktailId){
        Optional<Cocktail> cocktailOptional = cocktailRepository.findById(cocktailId);
        cocktailOptional.ifPresent(cocktail -> cocktailRepository.delete(cocktail));
    }

    @Transactional
    public void updateCocktailbyId(CocktailDto cocktailDto){
        Optional<Cocktail> cocktailOptional = cocktailRepository.findById(cocktailDto.getCocktailID());
        cocktailOptional.ifPresent(cocktail -> {
            cocktail.setCocktailName(cocktailDto.getCocktailName());
            cocktail.setDirections(cocktailDto.getDirections());
            cocktail.setIngredients(cocktailDto.getIngredients());
            cocktail.setGlassType(cocktailDto.getGlassType());
            cocktail.setImgURL(cocktailDto.getImgURL());
            cocktailRepository.saveAndFlush(cocktail);
        });
    }
}
