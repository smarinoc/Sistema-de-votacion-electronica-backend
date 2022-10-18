package co.edu.udea.iot.backend.mapper;

import co.edu.udea.iot.backend.dto.VoterDTO;
import co.edu.udea.iot.backend.model.Voter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VoterMapper {

        Voter toEntity(VoterDTO dto);
        VoterDTO toDto(Voter voter);
}
