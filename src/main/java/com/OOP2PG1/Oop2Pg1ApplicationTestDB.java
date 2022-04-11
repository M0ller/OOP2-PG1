package com.OOP2PG1;

import com.OOP2PG1.models.User;
import com.OOP2PG1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Oop2Pg1ApplicationTestDB implements CommandLineRunner {

	private final UserRepository userRepository;

	@Autowired
	public Oop2Pg1ApplicationTestDB(UserRepository userRepository){
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Oop2Pg1ApplicationTestDB.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();

		if(userRepository.findAll().isEmpty()){
			userRepository.save(new User("Kalle", "kalle@email.com", "123abc"));
			userRepository.save(new User("Frank", "frank@email.com", "123abc"));
			userRepository.save(new User("Hilda", "hilda@email.com", "123abc"));
			userRepository.save(new User("Edith", "edith@email.com", "123abc"));
		}

		for(User user : userRepository.findAll()){
			System.out.println(user);
		}
	}
}
