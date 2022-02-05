package com.example.demo.basketballPlayer;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table
public class basketballPlayer {
    @Id
    @SequenceGenerator(
            name = "basketballPlayer_sequence",
            sequenceName = "basketballPlayer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "basketballPlayer_sequence"
    )
    private long id;
    @NotNull
    @Size(min=1,max=20)
    private String name;
    @NotNull
    @Size(min=1,max=20)
    private String lastName;
    @Min(value=1,message="Enter a valid position")
    @Max(value=5,message="Enter a valid position")
    @NotNull
    private int position;


    public basketballPlayer() {
    }

    public basketballPlayer(String name, String lastName, int position) {
        this.name = name;
        this.lastName = lastName;
        this.position = position;
    }

    public basketballPlayer(String name, String lastName, int position, long id) {
        this.id=id;
        this.name = name;
        this.lastName = lastName;
        this.position=position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "basketballPlayer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position=" + position +
                '}';
    }
}
