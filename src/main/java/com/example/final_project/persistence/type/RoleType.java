package com.example.final_project.persistence.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public enum RoleType {

    PERSONAL(Set.of(PermissionType.PERSONAL_CREATE, PermissionType.PERSONAL_UPDATE, PermissionType.PERSONAL_DELETE, PermissionType.PERSONAL_READ)),
    ADMIN(Set.of(PermissionType.ADMIN_CREATE, PermissionType.ADMIN_UPDATE, PermissionType.ADMIN_DELETE, PermissionType.ADMIN_READ));

    private final Set<PermissionType> getPermissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getGetPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
