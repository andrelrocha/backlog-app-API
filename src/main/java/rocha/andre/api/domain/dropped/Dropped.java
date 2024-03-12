package rocha.andre.api.domain.dropped;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import rocha.andre.api.domain.dropped.DTO.DroppedCreateDTO;
import rocha.andre.api.domain.dropped.DTO.DroppedUpdateDTO;
import rocha.andre.api.domain.game.Game;
import rocha.andre.api.domain.dropped.DTO.DroppedDTO;

@Table(name = "dropped")
@Entity(name = "Dropped")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Dropped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String console;
    private int note;
    @Column(name = "reason", columnDefinition = "TEXT")
    private String reason;
    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Game game;
    private String genre;

    public Dropped(DroppedCreateDTO data) {
        this.name = data.name();
        this.console = data.console();
        this.note = data.note();
        this.reason = data.reason();
        this.game = data.game();
        this.genre = data.genre();
    }

    public void updateDropped(DroppedUpdateDTO dto){
        if (dto.name() != null) {
            this.name = dto.name();
        }

        if (dto.genre() != null) {
            this.genre = dto.genre();
        }

        if (dto.console() != null) {
            this.console = dto.console();
        }

        if (dto.note() >= 0) {
            this.note = dto.note();
        }

        if (dto.reason() != null) {
            this.reason = dto.reason();
        }
    }
}

