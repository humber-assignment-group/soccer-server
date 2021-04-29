package com.github.humbergroup.soccer;

import com.github.humbergroup.soccer.model.Team;

import java.util.List;

public interface TeamService {

    Team createTeam(Team team);

    void addTeamIntoLeague(Long teamId, Long leagueId);

    Team getTeamById(Long id);

    List<Team> getTeamsByLeagueId(Long leagueId);

    void updateTeamName(Long id, String name);
}
