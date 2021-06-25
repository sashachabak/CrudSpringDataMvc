package com.spring.crudspringdatamvc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum Role {
    ADMIN (Set.of(
            Permission.DEVELOPERS_READ,
            Permission.DEVELOPERS_WRITE,
            Permission.DEVELOPERS_DELETE,
            Permission.DEVELOPERS_UPDATE)),
    USER (Set.of(
            Permission.DEVELOPERS_READ,
            Permission.DEVELOPERS_WRITE
    ));

    private final Set<Permission> permissions;

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream().map(
                permission -> new SimpleGrantedAuthority(permission.getPermission())).collect(Collectors.toSet());
    }
}
