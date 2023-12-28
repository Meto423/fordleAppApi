package com.example.fordleapi2.GameData;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class GameDataService {

    private final GameDataRepository gameDataRepository;


    @Autowired //dependency injection with constructor
    public GameDataService(GameDataRepository gameDataRepository) {
        this.gameDataRepository = gameDataRepository;
    }


    public void saveAll(List<GameData> gameData) {
        gameDataRepository.saveAll(gameData);
    }

    public List<GameData> findAll() {
        return gameDataRepository.findAll();
    }

    public List<Object[]> findUserStats(){
        return gameDataRepository.findUserStats();
    }





}
