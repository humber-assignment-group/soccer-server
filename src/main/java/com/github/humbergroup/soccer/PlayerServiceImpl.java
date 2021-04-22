package com.github.humbergroup.soccer;

import com.github.humbergroup.soccer.model.Player;

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
    public void addPlayer(Player player) {
        em.persist(player);
    }

    @Override
    public List<Player> getByTeamId(Long teamId) {
        return em.createNamedQuery("Player.findByTeamId", Player.class)
                .setParameter("teamId", teamId)
                .getResultList();
    }

    @Override
    public void delete(Long id) {
        em.remove(em.find(Player.class, id));
    }

    @Override
    public void update(Long id, Player player) {
        Player en = em.find(Player.class, id);
        en.setFirstName(player.getFirstName());
        en.setLastName(player.getLastName());
        en.setDateOfBirth(player.getDateOfBirth());
        em.persist(en);
    }
}
