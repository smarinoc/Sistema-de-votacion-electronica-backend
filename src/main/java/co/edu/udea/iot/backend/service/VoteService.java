package co.edu.udea.iot.backend.service;

import co.edu.udea.iot.backend.dto.VoteDTO;
import co.edu.udea.iot.backend.mapper.VoteMapper;
import co.edu.udea.iot.backend.model.Vote;
import co.edu.udea.iot.backend.repository.VoteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoteService {

    private final VoteRepository voteRepository;

    private final VoteMapper voteMapper;

    public VoteService(VoteRepository voteRepository, VoteMapper voteMapper) {
        this.voteRepository = voteRepository;
        this.voteMapper = voteMapper;
    }

    public void createVote(VoteDTO voteDTO) {
        Optional<Vote> vote = voteRepository.createVote(voteMapper.toEntity(voteDTO));
    }
}
