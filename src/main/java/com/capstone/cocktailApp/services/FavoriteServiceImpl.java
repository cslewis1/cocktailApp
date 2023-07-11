package com.capstone.cocktailApp.services;

import com.capstone.cocktailApp.dtos.CocktailDto;
import com.capstone.cocktailApp.dtos.FavoriteDto;
import com.capstone.cocktailApp.entities.Cocktail;
import com.capstone.cocktailApp.entities.Favorite;
import com.capstone.cocktailApp.entities.User;
import com.capstone.cocktailApp.repositories.CocktailRepository;
import com.capstone.cocktailApp.repositories.FavoriteRepository;
import com.capstone.cocktailApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FavoriteServiceImpl implements FavoriteService {
    @Autowired
    private FavoriteRepository favoriteRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CocktailRepository cocktailRepository;

//    @Override
//    @Transactional
//    public void addCocktailToFavorites(FavoriteDto favoriteDto, Long userId, Long cocktailId){
//        Optional<User> userOptional = userRepository.findById(userId);
//        Optional<Cocktail> cocktailOptional = cocktailRepository.findById(cocktailId);
//        Favorite favorite = new Favorite(favoriteDto);
//        userOptional.ifPresent(favorite::setUser);
//        cocktailOptional.ifPresent(favorite::setCocktail);
//        favoriteRepository.saveAndFlush(favorite);
//    }

    @Override
    @Transactional
    public void addCocktailToFavorites(FavoriteDto favoriteDto, Long userId, Long cocktailId){
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Cocktail> cocktailOptional = cocktailRepository.findById(cocktailId);
        if (userOptional.isPresent() && cocktailOptional.isPresent()) {
            User user = userOptional.get();
            Cocktail cocktail = cocktailOptional.get();

            Favorite favorite = new Favorite(favoriteDto);
            favorite.setUser(user);
            favorite.getCocktails().add(cocktail);

            user.getFavorites().add(favorite);

            userRepository.save(user);
            favoriteRepository.saveAndFlush(favorite);
        } else {
            throw new RuntimeException("User or Cocktail not found");
        }
    }


    @Override
    @Transactional
    public void deleteFavoriteById(Long favoriteId) {
        Optional<Favorite> favoriteOptional = favoriteRepository.findById(favoriteId);
        favoriteOptional.ifPresent(favorite -> favoriteRepository.delete(favorite));
    }

    @Override
    @Transactional
    public void updateFavorite(FavoriteDto favoriteDto) {
        Optional<Favorite> favoriteOptional = favoriteRepository.findById(favoriteDto.getFavoriteID());
        favoriteOptional.ifPresent(favorite -> {
            favorite.setNotes(favoriteDto.getNotes());
            favoriteRepository.saveAndFlush(favorite);
        });
    }

    @Override
    public Optional<FavoriteDto> getFavoriteById(Long favoriteId) {
        Optional<Favorite> favoriteOptional = favoriteRepository.findById(favoriteId);
        if (favoriteOptional.isPresent()){
            return Optional.of(new FavoriteDto(favoriteOptional.get()));
        }
        return Optional.empty();
    }

    @Override
    public List<FavoriteDto> getAllFavorite() {
        List<Favorite> favorites = favoriteRepository.findAll();
        if(!favorites.isEmpty()) {
            return favorites.stream()
                    .map(favorite -> new FavoriteDto(favorite))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
