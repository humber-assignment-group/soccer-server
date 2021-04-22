package com.github.humbergroup.soccer;

import com.github.humbergroup.soccer.model.Player;
import com.github.humbergroup.soccer.model.Team;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Remote(TeamService.class)
public class TeamServiceImpl implements TeamService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(Team team) {
        em.persist(team);
    }

    @Override
    public void addPlayerToTeam(Long teamId, Player player) {
        Team team = em.find(Team.class, teamId);
        player.setTeam(team);
        em.persist(player);
    }

    @Override
    public void updateTeamName(Long id, String name) {
        Team team = em.find(Team.class, id);
        team.setName(name);
        em.persist(team);
    }
}
