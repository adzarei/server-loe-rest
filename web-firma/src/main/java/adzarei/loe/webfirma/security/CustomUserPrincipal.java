package adzarei.loe.webfirma.security;

import adzarei.loe.webfirma.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class CustomUserPrincipal implements UserDetails {

    private User user;

    private Collection<SimpleGrantedAuthority> authorities;
    private Boolean enabled = true;

    public CustomUserPrincipal(User user) {
        this.user = user;
        this.authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("USER"));

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
