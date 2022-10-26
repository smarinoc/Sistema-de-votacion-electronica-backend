package co.edu.udea.iot.backend.mapper;

import co.edu.udea.iot.backend.dto.VoteDTO;
import co.edu.udea.iot.backend.model.Vote;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VoteMapper {
    Vote toEntity(VoteDTO dto);
    VoteDTO toDto(Vote vote);



}
