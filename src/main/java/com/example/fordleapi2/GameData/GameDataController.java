package com.example.fordleapi2.GameData;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameDataController {

    @Autowired
    private GameDataRepository gameDataRepository;



    @PostMapping(path = "api/v1/gamedata")
    public ResponseEntity<String> saveGameData(@RequestBody List<GameData> gameData){
        gameDataRepository.saveAll(gameData);
        return ResponseEntity.ok("Game Data Saved");
    }








}