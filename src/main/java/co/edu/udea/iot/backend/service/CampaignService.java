package co.edu.udea.iot.backend.service;

import co.edu.udea.iot.backend.dto.CampaignDTO;
import co.edu.udea.iot.backend.exception.DataDuplicatedException;
import co.edu.udea.iot.backend.mapper.CampaignMapper;
import co.edu.udea.iot.backend.model.Campaign;
import co.edu.udea.iot.backend.repository.CampaignRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import java.util.Optional;

@Service
@Validated
public class CampaignService {
    private final CampaignRepository campaignRepository;

    private final CampaignMapper mapper;

    public CampaignService(CampaignRepository campaignRepository, CampaignMapper mapper) {
        this.campaignRepository = campaignRepository;
        this.mapper = mapper;
    }

    public CampaignDTO saveCampaign(@Valid CampaignDTO campaignDTO) {
        Optional<Campaign> campaignOptional = campaignRepository.findByName(campaignDTO.getName());
        if (campaignOptional.isPresent()) {
            throw new DataDuplicatedException(String.format("There is already a campaign with name: %s", campaignDTO.getName()));
        }
        Campaign savedCampaign = campaignRepository.save(mapper.toEntity(campaignDTO));
        return mapper.toDto(savedCampaign);
    }
}
