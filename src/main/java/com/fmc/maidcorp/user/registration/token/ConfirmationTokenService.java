package com.fmc.maidcorp.user.registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    private final ConfirmationTokenRepository tokenRepository;


    public void saveConfirmationToken(ConfirmationToken token){

        tokenRepository.save(token);
    }

    public Optional <ConfirmationToken> getToken(String token){
       Optional<ConfirmationToken> foundToken=  tokenRepository.findByToken(token);
       return foundToken;
    }


}
