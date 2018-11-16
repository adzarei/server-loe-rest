package adzarei.loe.webfirma.security;

import adzarei.loe.webfirma.model.User;
import adzarei.loe.webfirma.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;




    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        return new CustomUserPrincipal(user);
    }
}
