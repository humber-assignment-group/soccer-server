package com.github.humbergroup.soccer;

import com.github.humbergroup.soccer.model.Team;

import java.util.List;

public interface TeamService {

    Long createTeam(Team team);

    Long createTeamWithLeagueId(Team team, Long leagueId);

    void addTeamIntoLeague(Long teamId, Long leagueId);

    Team getTeamById(Long id);

    List<Team> getTeamsByLeagueId(Long leagueId);

    void updateTeamName(Long id, String name);
}
