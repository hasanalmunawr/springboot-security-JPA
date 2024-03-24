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

    @PreAuthorize("hasAnyRole('STAFF, OWNER')")
    @GetMapping(path = "/staff")
    public ResponseEntity<?> staff(Principal principal) {
        return ResponseEntity.ok("Staff API Accessed By : " + principal.getName());
    }
    @PreAuthorize("hasAnyRole('MANAGER,OWNER')")
    @GetMapping(path = "/manager")
    public ResponseEntity<?> manager(Principal principal) {
        return ResponseEntity.ok("Manager API Accessed By : " + principal.getName());
    }

    @PreAuthorize("hasAnyRole('ADMIN, MANAGER, OWNER')")
    @GetMapping(path = "/admin")
    public ResponseEntity<?> admin(Principal principal) {
        return ResponseEntity.ok("Admin API Accessed By : " + principal.getName());
    }

    @PreAuthorize("hasRole('OWNER')")
    @GetMapping(path = "/owner")
    public ResponseEntity<?> owner(Principal principal) {
        return ResponseEntity.ok("Owner API Accessed By : " + principal.getName());
    }


}
