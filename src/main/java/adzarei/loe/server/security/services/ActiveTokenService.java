package adzarei.loe.server.security.services;

import adzarei.loe.server.security.model.ActiveToken;

import java.util.List;
import java.util.Optional;

public interface ActiveTokenService {

    Optional<ActiveToken> saveToken(ActiveToken token);
    List<ActiveToken> findTokensByUsername();
    List<ActiveToken> findTokensByUserId();
    Optional<ActiveToken> patchToken(Long id, ActiveToken token);


    Optional<ActiveToken> findTokenByUuid(String uuid);
}
