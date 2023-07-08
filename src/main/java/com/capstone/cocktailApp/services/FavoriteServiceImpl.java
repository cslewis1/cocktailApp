package com.capstone.cocktailApp.services;

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
import java.util.Optional;

@Service
public class FavoriteServiceImpl {
    @Autowired
    private FavoriteRepository favoriteRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CocktailRepository cocktailRepository;

}
