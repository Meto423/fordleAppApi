
//if a class, which is configured as a Spring bean,
// has only one constructor,
// the @Autowired annotation can be omitted and Spring will use that
// constructor and inject all necessary dependencies.

package com.example.fordleapi2.auth;


import com.example.fordleapi2.GameData.GameData;
import com.example.fordleapi2.GameData.GameDataRepository;
import com.example.fordleapi2.config.JwtService;
import com.example.fordleapi2.user.MyUser;
import com.example.fordleapi2.user.Role;
import com.example.fordleapi2.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    // all injected dependencies are final and are initialized in the constructor
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final GameDataRepository gamedataRepository;


    public AuthenticationResponse register(RegisterRequest request) { // create a user, save it to the database, and return a JWT token

        var user = MyUser.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        var gameData = GameData.builder()
                .playedGames(0)
                .winStreak(0)
                .winCount(0)
                .user(user)
                .build();

        user.setGameData(gameData);


        userRepository.save(user);
        gamedataRepository.save(gameData);


        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        ); // if this function gets executed, it means that the user is authenticated
        var user = userRepository.findUserByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
