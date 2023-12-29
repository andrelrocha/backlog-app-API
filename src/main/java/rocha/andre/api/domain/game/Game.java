package rocha.andre.api.domain.game;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import rocha.andre.api.domain.game.DTO.GameDTO;
import rocha.andre.api.domain.game.DTO.GameReadCSVDTO;

@Table(name = "games")
@Entity(name = "Game")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int length;
    private int metacritic;
    private int excitement;
    private String genre;
    private boolean played;

    public Game(GameDTO gameDTO, boolean played) {
        this.name = gameDTO.name();
        this.length = gameDTO.length();
        this.metacritic = gameDTO.metacritic();
        this.excitement = gameDTO.excitement();
        this.genre = gameDTO.genre();
        this.played = played;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", metacritic=" + metacritic +
                ", excitement=" + excitement +
                ", genre='" + genre + '\'' +
                ", played=" + played +
                '}';
    }
}
