package com.emm.msparticipants.services.impl;

import com.emm.msparticipants.dtos.CreateParticipantDTO;
import com.emm.msparticipants.dtos.ParticipantDTO;
import com.emm.msparticipants.services.ParticipantService;

import java.util.List;

public class ParticipantServiceImpl implements ParticipantService {
    @Override
    public ParticipantDTO createParticipant(CreateParticipantDTO dto) {
        return null;
    }

    @Override
    public List<ParticipantDTO> getAllParticipants() {
        return List.of();
    }

    @Override
    public ParticipantDTO getParticipantById(Long id) {
        return null;
    }

    @Override
    public void deleteParticipant(Long id) {

    }

    @Override
    public ParticipantDTO updateParticipant(Long id, CreateParticipantDTO dto) {
        return null;
    }
}
