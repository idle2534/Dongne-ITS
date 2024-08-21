package com.dongne.its.project.repository;

import com.dongne.its.project.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Query("select p from Project p where p.id = :id and p.isDeleted = false")
    public Optional<Project> findProjectById(@Param("id") Long id);


    @Query("select p from Project p where p.id = :id and p.isDeleted = false")
    Optional<Project> findProjectByIdandProjectId(@Param("id") Long id, @Param("projectId") Long projectId);
}
