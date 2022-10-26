package co.edu.udea.iot.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "vote")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "voter")
    private Voter voter;

    @ManyToOne
    @JoinColumn(name = "candidate")
    private Candidate candidate;

    public Vote(){}

    public Vote(Voter voter, Candidate candidate) {
        this.voter = voter;
        this.candidate = candidate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Voter getVoter() {
        return voter;
    }

    public void setVoter(Voter voter) {
        this.voter = voter;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
}
