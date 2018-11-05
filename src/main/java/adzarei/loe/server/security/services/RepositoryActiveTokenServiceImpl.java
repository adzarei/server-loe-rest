package adzarei.loe.server.security.services;

import adzarei.loe.server.security.model.ActiveToken;
import adzarei.loe.server.security.repositories.ActiveTokenRepository;
import lombok.NonNull;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class RepositoryActiveTokenServiceImpl implements ActiveTokenService {

    @NonNull private final ActiveTokenRepository activeTokenRepository;

    public RepositoryActiveTokenServiceImpl(ActiveTokenRepository activeTokenRepository) {
        this.activeTokenRepository = activeTokenRepository;
    }

    @Override
    public Optional<ActiveToken> saveToken(ActiveToken token) {
        return Optional.of(activeTokenRepository.save(token));
    }

    @Override
    public List<ActiveToken> findTokensByUsername() {
        return null;
    }

    @Override
    public List<ActiveToken> findTokensByUserId() {
        return null;
    }

    @Override
    public Optional<ActiveToken> patchToken(Long id, ActiveToken token) {
        return Optional.empty();
    }

    @Override
    public Optional<ActiveToken> findTokenByUuid(String uuid) {
        return Optional.of(activeTokenRepository.findByUuid(uuid));
    }
}
