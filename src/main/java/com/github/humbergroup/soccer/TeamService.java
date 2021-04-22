package com.github.humbergroup.soccer;

import com.github.humbergroup.soccer.model.Player;
import com.github.humbergroup.soccer.model.Team;

public interface TeamService {

    void create(Team team);

    void addPlayerToTeam(Long teamId, Player player);

    void updateTeamName(Long id, String name);
}
