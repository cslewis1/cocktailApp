//package com.capstone.cocktailApp.services;
//
//import com.capstone.cocktailApp.dtos.CocktailDto;
//import com.capstone.cocktailApp.entities.Cocktail;
//import com.capstone.cocktailApp.entities.User;
//import com.capstone.cocktailApp.repositories.CocktailRepository;
//import com.capstone.cocktailApp.repositories.UserRepository;
//import org.hibernate.sql.model.jdbc.OptionalTableUpdateOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Optional;
//
//@Service
//public class CocktailServiceImpl {
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private CocktailRepository cocktailRepository;
//
//    @Transactional
//    public void addCocktail(CocktailDto cocktailDto, Long userId){
//        Optional<User> userOptional = userRepository.findById(userId);
//        Cocktail cocktail = new Cocktail(cocktailDto);
//        userOptional.ifPresent(cocktail::setUser);
//        cocktailRepository.saveAndFlush(cocktail);
//    }
//
//    @Transactional
//    public void deleteCocktailbyId(Long cocktailId){
//        Optional<Cocktail> cocktailOptional = cocktailRepository.findById(cocktailId);
//        cocktailOptional.isPresent(cocktail -> cocktailRepository.delete(cocktail));
//    }
//
//    @Transactional
//    public void updateCocktailbyId(CocktailDto cocktailDto){
//        Optional<Cocktail> cocktailOptional = cocktailRepository.findById(cocktailDto.getCocktailID());
//        cocktailOptional.ifPresent(cocktail -> {
//            cocktail.setBody(cocktailDto.getBody());
//            cocktailRepository.saveAndFlush(cocktail);
//        });
//
//    }
//}
