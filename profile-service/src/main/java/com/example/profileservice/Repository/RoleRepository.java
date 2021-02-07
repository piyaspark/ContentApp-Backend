package com.example.profileservice.Repository;

import com.example.profileservice.Model.Role;
import com.example.profileservice.Model.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findRoleByName(RoleEnum name);
}
