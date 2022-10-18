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
}
