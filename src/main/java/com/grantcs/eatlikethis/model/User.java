package com.grantcs.eatlikethis.model;

import com.grantcs.eatlikethis.validation.ValidGroup1;
import com.grantcs.eatlikethis.validation.ValidGroup2;
import com.grantcs.eatlikethis.validation.ValidGroup3;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends BaseEntity<String> implements UserDetails {
    @Email(groups = ValidGroup1.class)
    private String email;
    @Column(unique = true)
    private String username;
    @NotBlank(groups = ValidGroup1.class)
    @Length(min = 8, max = 100, groups = ValidGroup2.class)
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,100}$", groups = ValidGroup3.class)
    private String password;

    public User secureUser(PasswordEncoder passwordEncoder) {
        return User
                .builder()
                .email(email)
                .username(username)
                .password(passwordEncoder.encode(password))
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
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
