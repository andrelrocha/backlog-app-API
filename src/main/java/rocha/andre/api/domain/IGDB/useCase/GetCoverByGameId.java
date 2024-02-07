package rocha.andre.api.domain.IGDB.useCase;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import rocha.andre.api.domain.IGDB.DTO.CoverResponseDTO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Component
public class GetCoverByGameId {

    public CoverResponseDTO getCover() {
        try {
            // URL da API
            URL url = new URL("https://api.igdb.com/v4/covers");

            // Abrindo a conexão
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Configurando o método de requisição
            connection.setRequestMethod("POST");

            // Adicionando cabeçalhos
            connection.setRequestProperty("Authorization", "Bearer ed6dwvb4ncyac05p8tbuix464zad4u");
            connection.setRequestProperty("Client-ID", "bzop9nlj40f6s24q3j3hbzyieo27a3");
            connection.setRequestProperty("Content-Type", "application/json");

            // Permitindo a escrita no corpo da requisição
            connection.setDoOutput(true);

            // Definindo o corpo da requisição
            String requestBody = "fields alpha_channel,animated,checksum,game,game_localization,height,image_id,url,width; where id='280467';";
            connection.getOutputStream().write(requestBody.getBytes("UTF-8"));

            // Obtendo a resposta
            int responseCode = connection.getResponseCode();

            // Lendo a resposta
            BufferedReader reader;
            if (responseCode == HttpURLConnection.HTTP_OK) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            // Transformando em um json de string
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            System.out.println("Resposta da API: " + response.toString());

            // Convertendo a resposta para uma lista de CoverResponseDTO
            var objectMapper = new ObjectMapper();
            List<CoverResponseDTO> coverResponseDTOs = objectMapper.readValue(response.toString(), new TypeReference<List<CoverResponseDTO>>() {});

            return coverResponseDTOs.get(0);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Aconteceu um problema no processo de receber a resposta do Cover de um jogo pela API do IGDB.");
        }
    }
}
