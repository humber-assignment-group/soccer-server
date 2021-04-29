package com.github.humbergroup.soccer;

import com.github.humbergroup.soccer.model.League;

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
    public League create(League league) {
        em.persist(league);
        return league;
    }
}
