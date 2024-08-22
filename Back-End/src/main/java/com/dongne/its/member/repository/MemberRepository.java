package com.dongne.its.member.repository;

import com.dongne.its.member.domain.Member;
import com.dongne.its.member.domain.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select m from Member m where m.id = :id")
    public Optional<Member> findMemberById(@Param("id") Long id);

    @Query("select m from Member m where m.signId = :signId and m.isDeleted = false")
    public Optional<Member> findMemberBySignId(@Param("signId") String signId);

    @Query("select m from Member m where m.role != 'ADMIN' and m.isDeleted = false")
    public List<Member> findAllMembers();

    @Query("SELECT pm.member FROM ProjectMember pm WHERE pm.project.id = :projectId")
    public List<Member> findMembersByProjectId(@Param("projectId") Long projectId);

    @Query("SELECT pm.member FROM ProjectMember pm WHERE pm.project.id = :projectId AND pm.member.role = :role")
    public List<Member> findMembersByProjectIdAndRole(@Param("projectId") Long projectId, @Param("role") Role role);
}
