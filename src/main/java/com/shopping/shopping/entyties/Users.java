package com.shopping.shopping.entyties;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Course> courses;


}
