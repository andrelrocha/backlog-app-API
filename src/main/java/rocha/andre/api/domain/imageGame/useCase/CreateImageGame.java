package rocha.andre.api.domain.imageGame.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rocha.andre.api.domain.game.GameRepository;
import rocha.andre.api.domain.imageGame.DTO.ImageGameDTO;
import rocha.andre.api.domain.imageGame.DTO.ImageGameReturnDTO;
import rocha.andre.api.domain.imageGame.ImageGame;
import rocha.andre.api.domain.imageGame.ImageGameRepository;
import rocha.andre.api.infra.exceptions.ValidationException;
import rocha.andre.api.infra.utils.imageCompress.ImageUtils;

import java.io.IOException;

@Component
public class CreateImageGame {
    @Autowired
    private ImageGameRepository imageGameRepository;
    @Autowired
    private GameRepository gameRepository;

    public ImageGameReturnDTO createImageGame(ImageGameDTO dto) throws IOException {
        byte[] imageBytes;
        try {
            imageBytes = dto.imageFile().getBytes();
        } catch (IOException e) {
            throw new ValidationException("Erro ao converter o arquivo para bytes");
        }

        var game = gameRepository.findById(dto.gameId())
                .orElseThrow(() -> new ValidationException("Não foi encontrado jogo com o id informado."));

        System.out.println("Chamou a primeira query de find by id");

        var existsByGameId = imageGameRepository.existsByGameId(game.getId());

        System.out.println("Chamou a segunda query de exist by game id");

        if (existsByGameId) {
            throw new ValidationException("Já foi encontrada uma imagem para o jogo informado");
        }

        //var imageGame = new ImageGame(imageBytes, game);

        byte[] compressedImageBytes = ImageUtils.compressImage(dto.imageFile().getBytes());

        if (compressedImageBytes == null) {
            throw new ValidationException("Erro ao comprimir a imagem. O resultado do método compressImage é nulo.");
        }

        var imageGame = ImageGame.builder()
                .game(game)
                .image(compressedImageBytes)
                .build();

        System.out.println("Antes de salvar o jogo");
        System.out.println("classe image do image game" + imageGame.getImage().getClass());
        System.out.println("classe game" + game.toString());
        System.out.println("classe image game" + imageGame.toString());

        var imageGameOnDB = imageGameRepository.save(imageGame);

        System.out.println("Depois de salvar o jogo");

        return new ImageGameReturnDTO(imageGameOnDB);
    }
}
