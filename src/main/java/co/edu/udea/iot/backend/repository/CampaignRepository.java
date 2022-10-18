package co.edu.udea.iot.backend.repository;

import co.edu.udea.iot.backend.model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CampaignRepository extends JpaRepository<Campaign, Integer> {
    Optional<Campaign> findByName(String name);
}
