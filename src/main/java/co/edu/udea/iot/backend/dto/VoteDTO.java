package co.edu.udea.iot.backend.dto;

import javax.validation.constraints.NotBlank;

public class VoteDTO {

    private Integer id;
    @NotBlank(message = "The voter is required")
    private VoterDTO voter;
    @NotBlank(message = "The candidate is required")
    private CandidateDTO candidate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public VoterDTO getVoter() {
        return voter;
    }

    public void setVoter(VoterDTO voter) {
        this.voter = voter;
    }

    public CandidateDTO getCandidate() {
        return candidate;
    }

    public void setCandidate(CandidateDTO candidate) {
        this.candidate = candidate;
    }
}
