package rocha.andre.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping
    public ResponseEntity<Page<OpinionReturnDTO>> getOpinions(@RequestParam(defaultValue = "0") int page,
                                                              @RequestParam(defaultValue = "15") int size,
                                                              @RequestParam(defaultValue = "name") String sortField,
                                                              @RequestParam(defaultValue = "asc") String sortOrder) {
        var pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortOrder), sortField));
        var opinionsPageable = opinionService.getOpinions(pageable);
        return ResponseEntity.ok(opinionsPageable);
    }

    @GetMapping("/byid/{id}")
    public ResponseEntity<OpinionReturnDTO> getOpinionById(@PathVariable long id) {
        var opinion = opinionService.getOpinionById(id);
        return ResponseEntity.ok(opinion);
    }
}