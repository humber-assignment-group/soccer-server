package com.github.humbergroup.soccer;

import com.github.humbergroup.soccer.model.League;
import com.github.humbergroup.soccer.model.Team;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@Remote(TeamService.class)
public class TeamServiceImpl implements TeamService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Long createTeam(Team team) {
        em.persist(team);
        return team.getId();
    }

    @Override
    public Long createTeamWithLeagueId(Team team, Long leagueId) {
        League league = em.find(League.class, leagueId);
        Helper.notNullRequired(league, "league not exist with id: " + leagueId);

        team.setLeague(league);
        return createTeam(team);
    }

    @Override
    public void addTeamIntoLeague(Long teamId, Long leagueId) {
        Team team = getTeamById(teamId);
        Helper.notNullRequired(team, "team not exist with id: " + teamId);

        League league = em.find(League.class, leagueId);
        Helper.notNullRequired(league, "league not exist with id: " + leagueId);

        team.setLeague(league);
        em.persist(team);
    }

    @Override
    public Team getTeamById(Long id) {
        return em.find(Team.class, id);
    }


    public List<Team> getTeamsByLeagueId(Long leagueId) {
        return em.createNamedQuery("Team.findByLeagueId", Team.class)
                .setParameter("league_id", leagueId)
                .getResultList();
    }

    @Override
    public void updateTeamName(Long id, String name) {
        Team team = em.find(Team.class, id);
        Helper.notNullRequired(team, "team not exist with id: " + id);

        team.setName(name);
        em.persist(team);
    }
}
