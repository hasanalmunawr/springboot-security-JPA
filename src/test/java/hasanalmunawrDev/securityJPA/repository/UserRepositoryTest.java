package hasanalmunawrDev.securityJPA.repository;

import hasanalmunawrDev.securityJPA.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByUsername() {
        UserEntity admin = userRepository.findByUsername("admin").orElse(null);
        assertNotNull(admin);
        assertNotNull(admin.getUsername());
        assertNotNull(admin.getPassword());
        log.info(admin.getUsername());
        log.info(admin.getPassword());
    }
}