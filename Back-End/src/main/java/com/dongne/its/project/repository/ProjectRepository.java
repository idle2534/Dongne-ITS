package com.dongne.its.project.repository;

import com.dongne.its.project.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT p from Project p WHERE p.id = :projectId")
    public Optional<Project> findProjectById(@Param("projectId") Long projectId);

    @Query("SELECT p from Project p WHERE p.isDeleted = false ")
    public List<Project> findProjects();
}
