package co.edu.udea.iot.backend.mapper;

import co.edu.udea.iot.backend.dto.CampaignDTO;
import co.edu.udea.iot.backend.model.Campaign;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CampaignMapper {
    Campaign toEntity(CampaignDTO dto);
    CampaignDTO toDto(Campaign campaign);
}
