package com.github.humbergroup.soccer;

import com.github.humbergroup.soccer.model.Player;

import java.util.List;

public interface PlayerService {

    void addPlayer(Player player);

    List<Player> getByTeamId(Long teamId);

    void delete(Long id);

    void update(Long id, Player player);
}
