package edu.kea.math.goatsite.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "dislikes")
public class Dislike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long goatDisliker;

    @NotNull
    private Long goatDisliked;

    //Foreign key
    @ManyToOne
    @JoinColumn(name = "goat_id")
    private Dislike dislike;
}
