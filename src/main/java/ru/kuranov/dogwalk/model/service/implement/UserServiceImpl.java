package ru.kuranov.dogwalk.model.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.entity.security.AccountUser;
import ru.kuranov.dogwalk.model.entity.security.Role;
import ru.kuranov.dogwalk.model.service.interfaces.AccountUserService;
import ru.kuranov.dogwalk.model.service.interfaces.UserService;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final AccountUserService accountUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<? extends AccountUser> accountUser = accountUserService.findByUsername(username);
        if (accountUser.isPresent()) {
            return new org.springframework.security.core.userdetails.User(
                    accountUser.get().getUsername(),
                    accountUser.get().getPassword(),
                    mapRolesToAuthorities(accountUser.get().getRoles()));
        } else {
            throw new UsernameNotFoundException(String.format("User %s not found", accountUser.get().getUsername()));
        }
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole()))
                .collect(Collectors.toSet());
    }
}
