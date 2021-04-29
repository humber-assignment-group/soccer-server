package com.github.humbergroup.soccer;

import com.github.humbergroup.soccer.model.Player;
import com.github.humbergroup.soccer.model.Team;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@Remote(PlayerService.class)
public class PlayerServiceImpl implements PlayerService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Player createPlayer(Player player) {
        em.persist(player);
        return player;
    }

    @Override
    public void addPlayerIntoTeam(Long playerId, Long teamId) {
        Player player = getPlayerById(playerId);
        Helper.notNullRequired(player, "player not exist with id: " + playerId);
        Team team = em.find(Team.class, teamId);
        Helper.notNullRequired(team, "team not exist with id: " + teamId);

        player.setTeam(team);
        em.persist(player);
    }

    @Override
    public List<Player> getPlayersByTeamId(Long teamId) {
        return em.createNamedQuery("Player.findByTeamId", Player.class)
                .setParameter("teamId", teamId)
                .getResultList();
    }

    @Override
    public Player getPlayerById(Long id) {
        return em.find(Player.class, id);
    }

    @Override
    public void delete(Long id) {
        em.remove(em.find(Player.class, id));
    }

    @Override
    public void update(Player player) {
        Player en = em.find(Player.class, player.getId());
        Helper.notNullRequired(en, "player not exist with id: " + player.getId());

        en.setFirstName(player.getFirstName());
        en.setLastName(player.getLastName());
        en.setDateOfBirth(player.getDateOfBirth());
        em.merge(en);
    }
}
