package com.example.fordleapi2.GameData;


import com.example.fordleapi2.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class GameService {

    private final GameDataRepository gameDataRepository;


    @Autowired //dependency injection with constructor
    public GameService(GameDataRepository gameDataRepository) {
        this.gameDataRepository = gameDataRepository;
    }


}
