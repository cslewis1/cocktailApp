package com.capstone.cocktailApp.services;

import com.capstone.cocktailApp.dtos.CocktailDto;
import com.capstone.cocktailApp.entities.Cocktail;
import com.capstone.cocktailApp.entities.User;
import com.capstone.cocktailApp.repositories.CocktailRepository;
import com.capstone.cocktailApp.repositories.FavoriteRepository;
import com.capstone.cocktailApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CocktailServiceImpl implements CocktailService {
    @Autowired
    private FavoriteRepository favoriteRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CocktailRepository cocktailRepository;

//    @Override
//    @Transactional
//    public void addCocktail(CocktailDto cocktailDto, Long userId){
//        Optional<User> userOptional = userRepository.findById(userId);
//        if(userOptional.isPresent()){
//            User user = userOptional.get();
//            Cocktail cocktail = new Cocktail(cocktailDto);
//            cocktail.setUser(user);
//            cocktailRepository.saveAndFlush(cocktail);
//        }
//    }

    @Override
    @Transactional
    public void addCocktail(CocktailDto cocktailDto, Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        Cocktail cocktail = new Cocktail(cocktailDto);
        userOptional.ifPresent(cocktail::setUser);
        cocktailRepository.saveAndFlush(cocktail);
    }

    @Override
    @Transactional
    public void deleteCocktailById(Long cocktailId){
        Optional<Cocktail> cocktailOptional = cocktailRepository.findById(cocktailId);
        cocktailOptional.ifPresent(cocktail -> cocktailRepository.delete(cocktail));
    }

    @Override
    @Transactional
    public void updateCocktailById(CocktailDto cocktailDto){
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

    @Override
    public List<CocktailDto> getAllCocktailsByUserId(Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()){
            List<Cocktail> cocktailList = cocktailRepository.findAllByUserEquals(userOptional.get());
            return cocktailList.stream().map(cocktail -> new CocktailDto(cocktail)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<CocktailDto> getCocktailById(Long cocktailId) {
        Optional<Cocktail> cocktailOptional = cocktailRepository.findById(cocktailId);
        if (cocktailOptional.isPresent()){
            return Optional.of(new CocktailDto(cocktailOptional.get()));
        }
        return Optional.empty();
    }
}
