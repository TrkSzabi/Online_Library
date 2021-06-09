package com.sda.traianszabi.online_library;

import com.sda.traianszabi.online_library.model.LibraryAccount;
import com.sda.traianszabi.online_library.model.User;
import com.sda.traianszabi.online_library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.sda.traianszabi.online_library.repository")
@EntityScan(basePackages = "com.sda.traianszabi.online_library.model")
public class Online_Library_App implements CommandLineRunner {
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(Online_Library_App.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.refresh();

        LibraryAccount libraryAccount1 = new LibraryAccount();
        libraryAccount1.setId(1L);
        User user1 = new User();
        user1.setId(1);

        userService.addUser(libraryAccount1,user1);

    }

}
