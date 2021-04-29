package com.github.humbergroup.soccer.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@NamedQuery(name = "Player.findByTeamId", query = "SELECT p FROM Player p WHERE p.team.id =:teamId")
public class Player implements Serializable {

    @Id
    @SequenceGenerator(name = "player_sequence", sequenceName = "player_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_sequence")

    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "team_id")
    @JsonIgnore
    private Team team;

    @Column(name = "date_of_signup")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date signedUpDate;

    @PrePersist
    void createdAt() {
        this.signedUpDate = new Date();
    }

    @PreUpdate
    void updatedAt() {
        this.signedUpDate = new Date();
    }
}
