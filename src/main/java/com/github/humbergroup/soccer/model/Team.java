package com.github.humbergroup.soccer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@NamedQuery(name = "Team.findByLeagueId", query = "SELECT t FROM Team t WHERE t.league.id =:league_id")
public class Team implements Serializable {

    @Id
    @SequenceGenerator(name = "team_sequence", sequenceName = "team_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_sequence")
    
    private Long id;


    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER)
    private List<Player> players;

    @Column(name = "date_of_next_game")
    private Date dateOfNextGame;

    @ManyToOne
    @JoinColumn(name = "league_id")
    @JsonIgnore
    private League league;
}
