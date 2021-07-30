package com.padminisys.election.api.service;

import com.padminisys.election.dal.entity.Member;
import com.padminisys.election.dal.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("member")
public class MemberService {

    private final MemberRepository memberRepository;

    @RolesAllowed("admin")
    @PostMapping("/create")
    public @ResponseBody
    Member newMember(@RequestBody Member member, Principal principal) {
        LocalDateTime indiaTime = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));

        member.setUpdateTime(indiaTime);
        member.setCreationTime(indiaTime);

        member.setCreatedBy(principal.getName());
        member.setModifiedBy(principal.getName());

        Member newMember = memberRepository.save(member);
        log.info("new member {} created by {}", newMember, principal.getName());
        return newMember;
    }

    @RolesAllowed("admin")
    @PostMapping("/update")
    public @ResponseBody
    Member updateMember(@RequestBody Member member, Principal principal) {
        LocalDateTime indiaTime = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
        member.setUpdateTime(indiaTime);
        member.setModifiedBy(principal.getName());
        Member updatedMember = memberRepository.save(member);
        log.info("updated member {} modified by {}", updatedMember, principal.getName());
        return updatedMember;
    }
}