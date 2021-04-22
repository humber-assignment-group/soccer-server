package com.github.humbergroup.soccer;

import com.github.humbergroup.soccer.model.League;
import com.github.humbergroup.soccer.model.Team;

public interface LeagueService {

    void create(League league);

    void addTeam(Long leagueId, Team team);
}
