package rocha.andre.api.domain.opinion;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import rocha.andre.api.domain.game.Game;
import rocha.andre.api.domain.opinion.DTO.OpinionCreateDTO;
import rocha.andre.api.domain.opinion.DTO.OpinionDTO;
import rocha.andre.api.domain.opinion.DTO.OpinionUpdateDTO;

@Table(name = "opinions")
@Entity(name = "Opinion")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Opinion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String console;
    private int note;
    @Column(name = "opinion", columnDefinition = "TEXT")
    private String opinion;
    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Game game;
    private int metacritic;
    private String genre;

    public Opinion(OpinionCreateDTO data) {
        this.name = data.name();
        this.console = data.console();
        this.note = data.note();
        this.opinion = data.opinion();
        this.game = data.game();
        this.metacritic = data.metacritic();
        this.genre = data.genre();
    }

    public void updateOpinion(OpinionUpdateDTO dto){
        if (dto.name() != null) {
            this.name = dto.name();
        }

        if (dto.console() != null) {
            this.console = dto.console();
        }

        if (dto.note() >= 0) {
            this.note = dto.note();
        }

        if (dto.opinion() != null) {
            this.opinion = dto.opinion();
        }

        if (dto.metacritic() >= 0) {
            this.metacritic = dto.metacritic();
        }

        if (dto.genre() != null) {
            this.genre = dto.genre();
        }
    }
}
