package rocha.andre.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rocha.andre.api.domain.dropped.DTO.DroppedDTO;
import rocha.andre.api.domain.dropped.DTO.DroppedReturnDTO;
import rocha.andre.api.domain.dropped.DTO.DroppedUpdateDTO;
import rocha.andre.api.domain.finished.DTO.FinishedReturnDTO;
import rocha.andre.api.domain.finished.DTO.FinishedUpdateDTO;
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

    @GetMapping
    public ResponseEntity<Page<DroppedReturnDTO>> getDroppedGames(@RequestParam(defaultValue = "0") int page,
                                                              @RequestParam(defaultValue = "15") int size,
                                                              @RequestParam(defaultValue = "name") String sortField,
                                                              @RequestParam(defaultValue = "asc") String sortOrder) {
        var pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortOrder), sortField));
        var droppedGamesPageable = droppedService.getDroppedGames(pageable);
        return ResponseEntity.ok(droppedGamesPageable);
    }

    @GetMapping("/byid/{id}")
    public ResponseEntity<DroppedReturnDTO> getDroppedGameById(@PathVariable long id) {
        var droppedGame = droppedService.getDroppedById(id);
        return ResponseEntity.ok(droppedGame);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DroppedReturnDTO> updateDropped(@RequestBody DroppedUpdateDTO data, @PathVariable long id) {
        var updatedFinished = droppedService.updateDropped(data, id);
        return ResponseEntity.ok(updatedFinished);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDropped(@PathVariable long id) {
        droppedService.deleteDropped(id);
        return ResponseEntity.noContent().build();
    }
}
