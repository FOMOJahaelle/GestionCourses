package com.shopping.shopping.entyties;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Table(name = "course")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable=true)
    private String name;
    @Column(nullable=true)
    private String description;
    @Column(nullable=true)
    private Date dateCreation;
    @Column(nullable=true)
    private Boolean archive;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Taches> taches;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Users user;
}
