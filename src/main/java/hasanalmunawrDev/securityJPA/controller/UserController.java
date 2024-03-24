package hasanalmunawrDev.securityJPA.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(path = "/api")
public class UserController {

    @GetMapping(path = "/anyone")
    public ResponseEntity<?> anyone(Principal principal) {
        return ResponseEntity.ok("Anyone API accessed By : " + principal.getName());
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN, ROLE_BOSS')")
    @GetMapping(path = "/manager")
    public ResponseEntity<?> manager(Principal principal) {
        return ResponseEntity.ok("Manager API Accessed By : " + principal.getName());
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN, ROLE_MANAGER, ROLE_BOSS')")
    @GetMapping(path = "/admin")
    public ResponseEntity<?> admin(Principal principal) {
        return ResponseEntity.ok("Admin API Accessed By : " + principal.getName());
    }

    @PreAuthorize("hasRole('ROLE_BOSS')")
    @GetMapping(path = "/boss")
    public ResponseEntity<?> owner(Principal principal) {
        return ResponseEntity.ok("Boss API Accessed By : " + principal.getName());
    }


}
