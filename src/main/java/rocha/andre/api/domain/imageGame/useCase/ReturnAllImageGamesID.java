package rocha.andre.api.domain.imageGame.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rocha.andre.api.domain.imageGame.ImageGameRepository;

import java.util.ArrayList;


@Component
public class ReturnAllImageGamesID {
    @Autowired
    private ImageGameRepository repository;

    public ArrayList<Long> returnAllIds() {
        var allIds = repository.findAllGameIdsOrderedByName();

        return allIds;
    }

}
