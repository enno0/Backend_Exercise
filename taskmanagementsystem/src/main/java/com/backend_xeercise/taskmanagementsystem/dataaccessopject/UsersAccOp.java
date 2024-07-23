package com.backend_xeercise.taskmanagementsystem.dataaccessopject;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend_xeercise.taskmanagementsystem.models.Users;

public interface UsersAccOp extends JpaRepository<Users, Long> {

}
