package com.shopping.shopping.entyties;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Table(name = "taches")
public class Taches implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable=false)
    private String nameTache;
    @Column(nullable=false)
    private String description;
    @Column(nullable=false)
    private Boolean statut;

    @ManyToOne
    @JoinColumn(name ="course_id")
    private Course course;

//    public Taches(Long id, String nameTache, String description, Boolean statut) {
//        this.id = id;
//        this.nameTache = nameTache;
//        this.description = description;
//        this.statut = statut;
//    }


//    public Taches(Long id, String nameTache, String description, Boolean statut, Course course) {
//        this.id = id;
//        this.nameTache = nameTache;
//        this.description = description;
//        this.statut = statut;
//        this.course = course;
//    }
}
