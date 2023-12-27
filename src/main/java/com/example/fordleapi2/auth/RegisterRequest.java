package com.example.fordleapi2.auth;

import com.example.fordleapi2.GameData.GameData;
import com.example.fordleapi2.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String name;
    private String surname;
    private String email;
    private String password;
    private String username;
}
