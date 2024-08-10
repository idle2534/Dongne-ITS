package com.dongne.its.member.repository;

import com.dongne.its.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select u from Member u where u.id = :id and u.isDeleted = false")
    public Optional<Member> findMemberById(@Param("id") Long id);

    @Query("select u from Member u where u.signId = :signId and u.isDeleted = false")
    public Optional<Member> findMemberBySignId(@Param("signId") String signId);

    @Query("select u from Member u where u.role != 'ADMIN' and u.isDeleted = false")
    public List<Member> findAllMembers();

    //public List<Member> findByIdAndProjectId(Long memberId, Long projectId);

    //public List<Member> findByIdAndProjectIdAndRole(Long memberId, Long projectId, String role);
}
