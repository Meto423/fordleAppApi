package com.example.fordleapi2.GameData;


import com.example.fordleapi2.user.MyUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "gamedata")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GameData {


    @Id
    @SequenceGenerator(
            name = "game_data_sequence",
            sequenceName = "game_data_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "game_data_sequence"
    )
    @Column(name = "id", updatable = false)
    Long id;

    @Column(name = "playedgames")

    Integer playedGames;
    @Column(name = "wincount")

    Integer winCount;

    @Column(name = "winstreak")

    Integer winStreak;

    @OneToOne(mappedBy = "gameData")
    private MyUser user;












}
