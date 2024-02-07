package rocha.andre.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rocha.andre.api.domain.IGDB.useCase.GetCoverByGameId;

@RestController
@RequestMapping("/igdb")
public class IGDBApiController {
    @Autowired
    private GetCoverByGameId getCoverByGameId;

    @GetMapping("/getcover")
    public ResponseEntity getCoverByGameId() {
        var response = getCoverByGameId.getCover();
        return ResponseEntity.ok(response);
    }
}
