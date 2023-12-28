package com.example.fordleapi2.GameData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameDataRepository extends JpaRepository<GameData, Long>{

    @Query("SELECT u.username, g.playedGames, g.winCount, g.winStreak FROM MyUser u JOIN u.gameData g")
    List<Object[]> findUserStats();




}
