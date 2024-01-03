package rocha.andre.api.domain.game;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GameRepository extends JpaRepository<Game, Long> {
    boolean existsByName(String name);

    @Query("""
            SELECT g FROM Game g
            """)
    Page<Game> findAllGames(Pageable pageable);
}
