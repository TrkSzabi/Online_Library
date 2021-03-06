package com.sda.traianszabi.online_library.service;


import com.sda.traianszabi.online_library.model.LibraryAccount;
import com.sda.traianszabi.online_library.model.User;
import com.sda.traianszabi.online_library.repository.LibraryAccountRepository;
import com.sda.traianszabi.online_library.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService implements UserDetailsService {
    private final LibraryAccountRepository libraryAccountRepository;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(LibraryAccountRepository libraryAccountRepository, UserRepository userRepository, UserRepository userRepository1, BCryptPasswordEncoder passwordEncoder) {
        this.libraryAccountRepository = libraryAccountRepository;
        this.userRepository = userRepository1;
        this.passwordEncoder = passwordEncoder;
    }

    public void addUser(LibraryAccount libraryAccount, User user) {
        libraryAccountRepository.save(libraryAccount);
        userRepository.save(user);
    }

    public Iterable<LibraryAccount> getUserAccounts() {
        return libraryAccountRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password!");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername()
                , user.getPassword()
                , new ArrayList<>());
    }

    public void createUser(User user) {
        User userToBeSaved = new User();
        userToBeSaved.setUsername(user.getUsername());
        userToBeSaved.setPassword(passwordEncoder.encode(user.getPassword()));
        userToBeSaved.setEmail(user.getEmail());
        userToBeSaved.setPhone(user.getPhone());
        userRepository.save(userToBeSaved);
    }

    public boolean userExist(String username) {
        User userExisting = userRepository.findByUsername(username);
        return userExisting != null;
    }

    public List<User> findAll(){
        return StreamSupport.stream(userRepository.findAll().spliterator(),
                false).collect(Collectors.toList());
    }
}
