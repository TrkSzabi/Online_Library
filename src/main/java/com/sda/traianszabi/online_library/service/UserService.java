package com.sda.traianszabi.online_library.service;


import com.sda.traianszabi.online_library.model.LibraryAccount;
import com.sda.traianszabi.online_library.model.User;
import com.sda.traianszabi.online_library.repository.LibraryAccountRepository;
import com.sda.traianszabi.online_library.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final LibraryAccountRepository libraryAccountRepository;
    private final UserRepository userRepository;

    public UserService(LibraryAccountRepository libraryAccountRepository, UserRepository userRepository, UserRepository userRepository1) {
        this.libraryAccountRepository = libraryAccountRepository;
        this.userRepository = userRepository1;
    }
    public void addUser(LibraryAccount libraryAccount, User user) {
        libraryAccountRepository.save(libraryAccount);
        userRepository.save(user);
    }
    public Iterable<LibraryAccount> getUserAccounts(){
        return libraryAccountRepository.findAll();
    }
}
