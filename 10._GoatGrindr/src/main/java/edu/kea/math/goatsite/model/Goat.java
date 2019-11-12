package edu.kea.math.goatsite.model;

//Repræsentere en goat i tabellen

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.List;

@Data //Laver getter og setter
@Entity
@Table(name = "goats")
public class Goat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @NotNull
    @Past
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private Date dob;

    @Length(max = 120)
    private String shortDescription;

    @Length(max = 10000)
    private String longDescription;

    @Email(message = "Email should be valid")
    private String username;

    @Enumerated(EnumType.STRING)
    private Gender gender;


    @OneToMany(mappedBy = "goatLiker")
    @JsonIgnore
    private List<Like> goatLiker;


    @OneToMany(mappedBy = "goatLiked")
    @JsonIgnore
    private List<Like> goatLiked;

/*
    @OneToMany(mappedBy = "dislike")
    private List<Dislike> dislikes;
*/

}
