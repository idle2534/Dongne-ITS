package com.dongne.its.Member.dao;

import com.dongne.its.Member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findBySignId(Long signId);
    List<Member> findAll();
}
