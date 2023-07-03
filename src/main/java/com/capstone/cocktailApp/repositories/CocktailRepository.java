package com.capstone.cocktailApp.repositories;

import com.capstone.cocktailApp.entities.Cocktail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CocktailRepository extends JpaRepository<Cocktail, Long> {
}
