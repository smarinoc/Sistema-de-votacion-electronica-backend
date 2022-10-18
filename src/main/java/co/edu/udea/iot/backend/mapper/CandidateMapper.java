package co.edu.udea.iot.backend.mapper;

import co.edu.udea.iot.backend.dto.CandidateDTO;
import co.edu.udea.iot.backend.model.Candidate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CandidateMapper {
    Candidate toEntity(CandidateDTO dto);
    CandidateDTO toDto(Candidate candidate);
}
