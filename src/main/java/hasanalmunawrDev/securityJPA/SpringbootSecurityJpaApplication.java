package hasanalmunawrDev.securityJPA;

import hasanalmunawrDev.securityJPA.entity.Role;
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
			UserEntity staff = new UserEntity();
			staff.setUsername("staff");
			staff.setPassword(passwordEncoder.encode("rahasia"));
			staff.setRoles(Role.STAFF.getName());

			UserEntity manager = new UserEntity();
			manager.setUsername("manager");
			manager.setPassword(passwordEncoder.encode("rahasia"));
			manager.setRoles(Role.MANAGER.getName());

			UserEntity admin = new UserEntity();
			admin.setUsername("admin");
			admin.setPassword(passwordEncoder.encode("rahasia"));
			admin.setRoles(Role.ADMIN.getName());

			UserEntity owner = new UserEntity();
			owner.setUsername("hasan");
			owner.setPassword(passwordEncoder.encode("rahasia"));
			owner.setRoles(Role.OWNER.getName()); // ERROR AT THIS LINE


			userRepository.saveAll(List.of(admin, manager, owner, staff));
		};
	}
}
