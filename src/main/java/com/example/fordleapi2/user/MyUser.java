package com.example.fordleapi2.user;


//import com.example.fordleapi2.GameData.GameData;
//import com.example.fordleapi2.GameData.GameDataRepository;
import com.example.fordleapi2.GameData.GameData;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Entity(name="MyUser")
@Table(name = "myuser",
        uniqueConstraints = {
                @UniqueConstraint(name = "myuser_email_unique", columnNames = "email")
        })
@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor

public class MyUser implements UserDetails {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1 // how many ids to increment by
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"// name of the sequence generator above
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )

    private String name;

    @Column(
            name = "surname",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String surname;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"

    )

    private String email;
    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String password;

    @Column(
            name = "username",
            nullable = false,
            columnDefinition = "TEXT"
    )

    private String username;

    @Enumerated(EnumType.STRING)
    private Role role;



    //address_add_id
    @OneToOne(cascade =CascadeType.ALL)//one user can have one gamedata
    @JoinColumn(name = "gamedata_id")
    private GameData gameData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name( )));
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString(){
        return "MyUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email=" + email +
                ", password=" + password +
                '}';
    }



}
