package com.emm.msparticipants.mappers;


import com.emm.msparticipants.dtos.CreateParticipantDTO;
import com.emm.msparticipants.dtos.ParticipantDTO;
import com.emm.msparticipants.models.Participant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ParticipantMapper {
    @Mapping(target = "participantId", ignore = true)
    void updateParticipantFromDto(CreateParticipantDTO dto, @MappingTarget Participant participant);
    ParticipantDTO toDto(Participant participant);
    Participant toEntityFromCreateDto(CreateParticipantDTO createDto);
}