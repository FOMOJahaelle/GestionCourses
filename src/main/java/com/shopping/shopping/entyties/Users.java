package com.shopping.shopping.entyties;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shopping.shopping.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
//@Setter
//@Getter
@Builder
@Table(name = "utilisateur")
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable=false)
    private String userName;
    @Column(nullable=false)
    private String passWord;
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    @JsonProperty(value = "role", required = false)
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Course> courses;

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPassword() {
        return passWord;
    }

    public String getUsername() {
        return userName;
    }


}
