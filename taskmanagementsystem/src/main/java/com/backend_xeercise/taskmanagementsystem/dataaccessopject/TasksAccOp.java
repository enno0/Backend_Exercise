package com.backend_xeercise.taskmanagementsystem.dataaccessopject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.backend_xeercise.taskmanagementsystem.models.Tasks;

public interface TasksAccOp extends JpaRepository<Tasks, Long>, JpaSpecificationExecutor<Tasks> {

}
