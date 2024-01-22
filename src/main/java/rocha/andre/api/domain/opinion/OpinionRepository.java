package rocha.andre.api.domain.opinion;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface OpinionRepository extends JpaRepository<Opinion, Long> {
    @Query("""
            SELECT CASE WHEN COUNT(o) > 0
            THEN true ELSE false END
            FROM Opinion o WHERE o.game.id = :gameId
            """)
    boolean gameAlreadyExists(Long gameId);

    boolean existsByGameId(long game_id);

    @Query("""
            SELECT o FROM Opinion o
            """)
    Page<Opinion> findAllOpinions(Pageable pageable);
}
