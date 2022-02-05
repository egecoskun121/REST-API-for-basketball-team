package com.example.demo.basketballPlayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;
    @Autowired
    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository=playerRepository;
    }
    public List<basketballPlayer> getPlayers(){
        return playerRepository.findAll();

    }

    public void addNewPlayer(basketballPlayer player) {
        Optional<basketballPlayer> playerByName =playerRepository.findPlayerByName(player.getName());
        if(playerByName.isPresent()){
            throw new IllegalStateException("Name error");
        }
        playerRepository.save(player);
        System.out.println(player);
    }

    public void deletePlayer(Long playerID) {

       boolean exists= playerRepository.existsById(playerID);
       if(!exists){
           throw new IllegalStateException("Player with "+playerID+"does not exists");

       }
       playerRepository.deleteById(playerID);
    }


    @Transactional
    public void updatePlayer(Long playerID, String name, String lastName, Integer position) {
        basketballPlayer player=playerRepository.findById(playerID).orElseThrow(()-> new IllegalStateException("player with id "+playerID+"does not exists"));
        if(name!=null){
        player.setName(name);}
        if(lastName!=null) {
            player.setLastName(lastName);
        }
        if(position!=null){
        player.setPosition(position);
    }

}
}
