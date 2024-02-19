package rocha.andre.api.domain.imageGame;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import rocha.andre.api.domain.game.Game;

@Entity(name = "ImageGame")
@Table(name = "image_game")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ImageGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "game_id")
    private Long gameId;

    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Game game;

    @Lob
    @Column(name = "image")
    private byte[] image;
}
