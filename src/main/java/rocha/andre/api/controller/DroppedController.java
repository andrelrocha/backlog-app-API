package rocha.andre.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rocha.andre.api.domain.dropped.DTO.DroppedDTO;
import rocha.andre.api.domain.dropped.DTO.DroppedReturnDTO;
import rocha.andre.api.service.DroppedService;

@RestController
@RequestMapping("/droppedgames")
public class DroppedController {
    @Autowired
    private DroppedService droppedService;

    @PostMapping("/addgame")
    public ResponseEntity<DroppedReturnDTO> addGameToDropped(@RequestBody DroppedDTO data) {
        var droppedGame = droppedService.addGameToDropped(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(droppedGame);
    }
}
