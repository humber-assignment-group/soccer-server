package com.github.humbergroup.soccer;

import com.github.humbergroup.soccer.model.League;
import com.github.humbergroup.soccer.model.Team;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Remote(LeagueService.class)
public class LeagueServiceImpl implements LeagueService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(League league) {
        em.persist(league);
    }

    @Override
    public void addTeam(Long leagueId, Team team) {
        League league = em.find(League.class, leagueId);
        team.setLeague(league);
        em.persist(team);
    }
}
