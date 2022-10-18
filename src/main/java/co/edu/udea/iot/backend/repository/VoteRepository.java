package co.edu.udea.iot.backend.repository;

import co.edu.udea.iot.backend.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Integer> {

    Optional<Vote> createVote(Vote vote);
}
