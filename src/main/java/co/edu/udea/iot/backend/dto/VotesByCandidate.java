package co.edu.udea.iot.backend.dto;



public class VotesByCandidate {

    private Integer candidate;

    private Integer count;

    public VotesByCandidate() {
    }

    public VotesByCandidate(Integer candidate, Integer votesCount) {
        this.candidate = candidate;
        this.count = count;
    }

    public Integer getCandidate() {
        return candidate;
    }

    public void setCandidate(Integer candidate) {
        this.candidate = candidate;
    }

    public Integer getVotesCount() {
        return count;
    }

    public void setVotesCount(Integer votesCount) {
        count = votesCount;
    }
}
