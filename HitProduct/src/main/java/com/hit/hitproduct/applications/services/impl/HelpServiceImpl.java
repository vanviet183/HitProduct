package com.hit.hitproduct.applications.services.impl;

import com.hit.hitproduct.adapter.web.v1.transfer.responses.TrueFalseResponse;
import com.hit.hitproduct.applications.repositories.HelpRepository;
import com.hit.hitproduct.applications.services.HelpService;
import com.hit.hitproduct.configs.exceptions.NotFoundException;
import com.hit.hitproduct.domains.dtos.HelpDto;
import com.hit.hitproduct.domains.entities.Help;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HelpServiceImpl implements HelpService {

    @Autowired
    HelpRepository helpRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Help> getHelps() {
        return helpRepository.findAll();
    }

    @Override
    public Help getHelpById(Long id) {
        Optional<Help> help = helpRepository.findById(id);
        checkHelpException(help);
        return help.get();
    }

    @Override
    public Help createHelp(HelpDto helpDto) {
        return createOrUpdate(new Help(), helpDto);
    }

    @Override
    public Help updateHelp(Long id, HelpDto helpDto) {
        Optional<Help> help = helpRepository.findById(id);
        checkHelpException(help);
        return createOrUpdate(help.get(), helpDto);
    }

    private Help createOrUpdate(Help help, HelpDto helpDto) {
        modelMapper.map(helpDto, help);
        return helpRepository.save(help);
    }

    @Override
    public TrueFalseResponse deleteHelp(Long id) {
        Optional<Help> help = helpRepository.findById(id);
        checkHelpException(help);
        helpRepository.deleteById(id);
        return new TrueFalseResponse(true);
    }

    private void checkHelpException(Optional<Help> help) {
        if(help.isEmpty()) {
            throw new NotFoundException("Not Found");
        }
    }
}
