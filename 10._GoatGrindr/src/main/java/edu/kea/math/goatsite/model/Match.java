package edu.kea.math.goatsite.model;


import javax.persistence.*;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matchId;

    private Long senderGoatId;
    private Long receiverGoatId;
}
