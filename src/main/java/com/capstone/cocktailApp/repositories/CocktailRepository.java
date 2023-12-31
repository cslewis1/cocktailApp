package com.capstone.cocktailApp.repositories;

import com.capstone.cocktailApp.entities.Cocktail;
import com.capstone.cocktailApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CocktailRepository extends JpaRepository<Cocktail, Long> {
    List<Cocktail> findAllByUserEquals(User user);
}
