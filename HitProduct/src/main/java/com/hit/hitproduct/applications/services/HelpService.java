package com.hit.hitproduct.applications.services;

import com.hit.hitproduct.adapter.web.v1.transfer.responses.TrueFalseResponse;
import com.hit.hitproduct.domains.dtos.HelpDto;
import com.hit.hitproduct.domains.entities.Help;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface HelpService {

    List<Help> getHelps();

    Help getHelpById(Long id);

    Help createHelp(HelpDto helpDto);

    Help updateHelp(Long id, HelpDto helpDto);

    TrueFalseResponse deleteHelp(Long id);
}
