package com.capstone.cocktailApp.repositories;

import com.capstone.cocktailApp.entities.Favorite;
import com.capstone.cocktailApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
//    List<Favorite> findAllByUserEquals(User user);
}
