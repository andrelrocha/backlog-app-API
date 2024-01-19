package rocha.andre.api.domain.opinion;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import rocha.andre.api.domain.game.Game;
import rocha.andre.api.domain.opinion.DTO.OpinionCreateDTO;

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

    public Opinion(OpinionCreateDTO data) {
        this.name = data.name();
        this.console = data.console();
        this.note = data.note();
        this.opinion = data.opinion();
        this.game = data.game();
    }
}