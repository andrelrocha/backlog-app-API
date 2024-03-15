package rocha.andre.api.domain.imageGame;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import rocha.andre.api.domain.imageGame.DTO.ImageGameIdDTO;
import rocha.andre.api.domain.imageGame.DTO.ImageGameReturnDTO;
import rocha.andre.api.domain.playingGame.PlayingGame;

import java.util.ArrayList;

public interface ImageGameRepository  extends JpaRepository<ImageGame, Long> {

    boolean existsByGameId(long game_id);

    ImageGame findImageGameByGameId(long game_id);

    @Query("""
        SELECT ig.game.id FROM ImageGame ig
        ORDER BY ig.game.name
    """)
    Page<Long> findAllGameIdsOrderedByName(Pageable pageable);

    @Query("""
            SELECT ig FROM ImageGame ig
            """)
    Page<ImageGame> findAllImageGames(Pageable pageable);

    @Transactional
    @Modifying
    @Query("DELETE FROM ImageGame ig WHERE ig.game_id = :gameId")
    void deleteByGameId(long gameId);
}
