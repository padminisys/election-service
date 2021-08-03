package com.padminisys.election.dal.repository;

import com.padminisys.election.dal.entity.House;
import com.padminisys.election.dal.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUserId(String userId);

    Optional<Member> findMemberByName(String name);

    List<Member> findMembersByHouse(House house);
}
