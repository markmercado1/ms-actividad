package com.emm.msparticipants.mappers;

import com.emm.msparticipants.dtos.CreateRegistrationDTO;
import com.emm.msparticipants.dtos.RegistrationDTO;
import com.emm.msparticipants.models.Registration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RegistrationMapper {

    @Mapping(target = "participantId", expression = "java(registration.getParticipant() != null ? registration.getParticipant().getParticipantId() : null)")
    RegistrationDTO toDto(Registration registration);

    @Mapping(target = "participant", expression = "java(new Participant(createDto.getParticipantId()))")
    @Mapping(target = "status", expression = "java(com.emm.msparticipants.enums.RegistrationStatus.PENDING)")
    @Mapping(target = "registrationDate", expression = "java(java.time.LocalDateTime.now())")
    Registration toEntityFromCreateDto(CreateRegistrationDTO createDto);
}