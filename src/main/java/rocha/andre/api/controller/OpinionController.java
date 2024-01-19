package rocha.andre.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rocha.andre.api.domain.opinion.DTO.OpinionDTO;
import rocha.andre.api.domain.opinion.DTO.OpinionReturnDTO;
import rocha.andre.api.service.OpinionService;

@RestController
@RequestMapping("/opinions")
public class OpinionController {
    @Autowired
    private OpinionService opinionService;

    @PostMapping("/create")
    public ResponseEntity<OpinionReturnDTO> createOpinion(@RequestBody OpinionDTO data) {
        var opinion = opinionService.createOpinion(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(opinion);
    }
}