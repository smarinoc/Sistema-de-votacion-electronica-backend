package co.edu.udea.iot.backend.dto;



public class VotesByCandidate {

    private Integer candidate;

    private Long count;

    public VotesByCandidate() {
    }

    public VotesByCandidate(Integer candidate, Long votesCount) {
        this.candidate = candidate;
        this.count = votesCount;
    }

    public Integer getCandidate() {
        return candidate;
    }

    public void setCandidate(Integer candidate) {
        this.candidate = candidate;
    }

    public Long getVotesCount() {
        return count;
    }

    public void setVotesCount(Long votesCount) {
        count = votesCount;
    }
}
