package co.edu.udea.iot.backend.service;

import co.edu.udea.iot.backend.mapper.CandidateMapper;
import co.edu.udea.iot.backend.model.Candidate;
import co.edu.udea.iot.backend.repository.CandidateRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;


@Service
@Validated
public class CandidateService {

    private final CandidateRepository candidateRepository;
    private final CandidateMapper mapper;

    public CandidateService(CandidateRepository candidateRepository, CandidateMapper mapper) {
        this.candidateRepository = candidateRepository;
        this.mapper = mapper;
    }


    public List<Candidate> getAllCandidate() {
        return candidateRepository.findAll();
    }




}
