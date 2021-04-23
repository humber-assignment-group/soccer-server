package com.github.humbergroup.soccer;

import com.github.humbergroup.soccer.model.Player;

import java.util.List;

public interface PlayerService {

    Long createPlayer(Player player);

    Long createPlayerWithTeamId(Player player, Long teamId);

    void addPlayerIntoTeam(Long playerId, Long teamId);

    List<Player> getPlayersByTeamId(Long teamId);

    Player getPlayerById(Long id);

    void delete(Long id);

    void update(Long id, Player player);
}
