package com.backend_xeercise.taskmanagementsystem.specification;

import org.springframework.data.jpa.domain.Specification;

import com.backend_xeercise.taskmanagementsystem.models.Tasks;

public class TaskSpecifications {

    public static Specification<Tasks> hasTitle(String title) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("title"), title);
    }

    public static Specification<Tasks> hasDescription(String description) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("description"), description);
    }

    public static Specification<Tasks> hasStatus(String status) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("status"), status);
    }
}