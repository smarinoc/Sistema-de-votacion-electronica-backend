package co.edu.udea.iot.backend.repository;

import co.edu.udea.iot.backend.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
}
