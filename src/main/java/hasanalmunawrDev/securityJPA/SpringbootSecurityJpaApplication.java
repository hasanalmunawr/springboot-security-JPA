package hasanalmunawrDev.securityJPA;

import hasanalmunawrDev.securityJPA.entity.UserEntity;
import hasanalmunawrDev.securityJPA.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class SpringbootSecurityJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSecurityJpaApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			UserEntity admin = new UserEntity();
			admin.setUsername("admin");
			admin.setPassword(passwordEncoder.encode("rahasia"));
			admin.setRoles("ROLE_ADMIN, ROLE_MANAGER");

			UserEntity manager = new UserEntity();
			manager.setUsername("manager");
			manager.setPassword(passwordEncoder.encode("rahasia"));
			manager.setRoles("ROLE_MANAGER");

			UserEntity boss = new UserEntity();
			boss.setUsername("hasan");
			boss.setPassword(passwordEncoder.encode("rahasia"));
			boss.setRoles("ROLE_ADMIN, ROLE_MANAGER, ROLE_BOSS"); // ERROR AT THIS LINE


			userRepository.saveAll(List.of(admin, manager, boss));
		};
	}
}
