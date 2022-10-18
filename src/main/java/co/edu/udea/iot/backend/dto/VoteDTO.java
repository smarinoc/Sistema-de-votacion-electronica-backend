package co.edu.udea.iot.backend.dto;

import javax.validation.constraints.NotBlank;

public class VoteDTO {

    private Integer id;
    @NotBlank(message = "The voter is required")
    private Integer voter;
    @NotBlank(message = "The candidate is required")
    private Integer candidate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVoterId() {
        return voter;
    }

    public void setVoterId(Integer voterId) {
        this.voter = voterId;
    }

    public Integer getCandidate() {
        return candidate;
    }

    public void setCandidate(Integer candidate) {
        this.candidate = candidate;
    }

}
