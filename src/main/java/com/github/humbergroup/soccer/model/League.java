package com.github.humbergroup.soccer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class League implements Serializable {

    @Id
    @SequenceGenerator(name = "team_sequence", sequenceName = "team_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_sequence")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "league", fetch = FetchType.EAGER)
    private List<Team> teams;
}
