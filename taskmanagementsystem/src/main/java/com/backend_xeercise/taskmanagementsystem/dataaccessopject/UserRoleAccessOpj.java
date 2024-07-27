package com.backend_xeercise.taskmanagementsystem.dataaccessopject;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend_xeercise.taskmanagementsystem.models.UserRole;

public interface UserRoleAccessOpj extends JpaRepository<UserRole, Long> {

}