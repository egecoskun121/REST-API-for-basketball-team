package com.example.demo.basketballPlayer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PlayerConfig {
    @Bean
CommandLineRunner commandLineRunner(PlayerRepository repo){
    return args ->{
        basketballPlayer mj=new basketballPlayer("Michael","Jordan",1);
        basketballPlayer jh=new basketballPlayer("James","Harden",1);
        basketballPlayer oa=new basketballPlayer("Omer","Asik",5);
        basketballPlayer sc=new basketballPlayer("Steph","Curry",1);
        basketballPlayer dh=new basketballPlayer("Dwight","Howard",5);
        basketballPlayer pg=new basketballPlayer("Paul","George",2);
        basketballPlayer th=new basketballPlayer("Tyler","Herro",3);
        basketballPlayer dr=new basketballPlayer("Dennis","Rodman",4);
        basketballPlayer bg=new basketballPlayer("Blake","Griffin",4);




        repo.saveAll(List.of(mj,jh,oa,sc,dh,pg,th,dr,bg));
    };

}
}
