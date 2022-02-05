package com.example.demo.basketballPlayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/players")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService){
        this.playerService=playerService;
    }

    @GetMapping
    public List<basketballPlayer> getPlayers(){
        return playerService.getPlayers();

    }
    @PostMapping
    public void registerNewPlayer(@RequestBody basketballPlayer player){
        playerService.addNewPlayer(player);
    }

    @DeleteMapping(path="{playerID}")
    public void deletePlayer(@PathVariable("playerID") Long id){
        playerService.deletePlayer(id);
    }
    @PutMapping(path="{playerID}")
    public void updatePlayer(@PathVariable("playerID") Long playerID,@RequestParam(required = false) String name,@RequestParam(required = false) String lastName,@RequestParam(required = false) Integer position){
        playerService.updatePlayer(playerID,name,lastName,position);
    }
}
