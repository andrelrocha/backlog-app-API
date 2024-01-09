package rocha.andre.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rocha.andre.api.infra.security.TokenJwtDto;
import rocha.andre.api.infra.security.TokenService;

@RestController
@RequestMapping("/infra")
public class InfraController {
    @Autowired
    private TokenService tokenService;

    @GetMapping("/verifyjwt")
    public boolean isTokenJWTValid(@RequestBody TokenJwtDto tokenJwt) {
        var isValid = tokenService.isJwtTokenValid(tokenJwt);

        if (!isValid) {
            throw new BadCredentialsException("Seu token de autenticação falhou. Você não tem autorização para acessar a aplicação.");
        }

        return true;
    }
}
