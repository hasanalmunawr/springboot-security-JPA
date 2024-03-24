package hasanalmunawrDev.securityJPA.config;

import hasanalmunawrDev.securityJPA.entity.Role;
import hasanalmunawrDev.securityJPA.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;


@RequiredArgsConstructor
public class UserSecurityConfig implements UserDetails {

    private final UserEntity userEntity;


//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Arrays
//                .stream(userEntity
//                        .getRoles()
//                        .split(","))
//                .map(SimpleGrantedAuthority::new)
//                .toList();
//    }
@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
    // Access the single Role directly:
    String role = userEntity.getRoles();
    // Map it to a GrantedAuthority:
    return Collections.singletonList(new SimpleGrantedAuthority(role));
}

    @Override
    public String getUsername() {
        return userEntity.getUsername();
    }

    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
