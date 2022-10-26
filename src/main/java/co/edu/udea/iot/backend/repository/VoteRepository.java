package co.edu.udea.iot.backend.repository;

import co.edu.udea.iot.backend.dto.VotesByCandidate;
import co.edu.udea.iot.backend.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Integer> {

    @Query(value = "select candidate, count(candidate) from vote GROUP BY candidate", nativeQuery = true)
    List<VotesByCandidate> votesByCandidate();
}
