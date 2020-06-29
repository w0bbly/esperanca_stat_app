package com.joaopimentel.esperancastats.Service;

import com.joaopimentel.esperancastats.DTO.TeamDTO;
import com.joaopimentel.esperancastats.Entity.Team;
import com.joaopimentel.esperancastats.Repository.GameMapping;
import com.joaopimentel.esperancastats.Repository.TeamMapping;
import com.joaopimentel.esperancastats.Repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final TeamMapping teamMapping;
    private final GameMapping gameMapping;

    public TeamService(TeamRepository teamRepository, TeamMapping teamMapping, GameMapping gameMapping) {
        this.teamRepository = teamRepository;
        this.teamMapping = teamMapping;
        this.gameMapping = gameMapping;
    }

    public TeamDTO getTeamById(Long id) {
        Optional<Team> team = teamRepository.findById(id);

        return team.map(teamMapping::toDto).orElse(null);
    }

    public List<TeamDTO> getAllTeams() {
        return teamMapping.toDto(teamRepository.findAll());
    }

    public TeamDTO createTeam(TeamDTO teamDTO) {
        Team team = new Team();

        team.setTeamName(teamDTO.getTeamName());
        team.setGames(gameMapping.toEntity(teamDTO.getGames()));

        teamRepository.save(team);

        return teamDTO;
    }

    public TeamDTO editTeam(Long id, TeamDTO team) {
        Optional<Team> t = teamRepository.findById(id);

        if(t.isPresent()) {
            t.get().setGames(gameMapping.toEntity(team.getGames()));
            t.get().setTeamName(team.getTeamName());
            teamRepository.save(t.get());
            return teamMapping.toDto(t.get());
        }

        return null;
    }

    public String deleteTeamById(Long id) {
        Optional<Team> t = teamRepository.findById(id);

        if(t.isPresent()) {
            teamRepository.delete(t.get());
            return t.get().getTeamName() + " deleted with success!";
        } else
            return null;
    }

    public String deleteAllTeams() {
        teamRepository.deleteAll();
        return  "All teams deleted with success!";
    }
}
