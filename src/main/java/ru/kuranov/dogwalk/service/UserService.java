package ru.kuranov.dogwalk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.repository.security.AccountUserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements  UserDetailsService {

    private final AccountUserRepository accountUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = accountUserRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new UsernameNotFoundException(String.format("User %s not found", optionalUser.get().getUsername()));
        }
    }
}
