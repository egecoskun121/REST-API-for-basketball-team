package com.example.demo.basketballPlayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository
        extends JpaRepository<basketballPlayer,Long> {
    @Query ("SELECT p FROM basketballPlayer p WHERE p.name = ?1 ")
    Optional<basketballPlayer> findPlayerByName(String name);





}
