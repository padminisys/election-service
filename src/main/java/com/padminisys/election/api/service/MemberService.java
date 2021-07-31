package com.padminisys.election.api.service;

import com.padminisys.election.api.exception.ObjectNotFoundException;
import com.padminisys.election.api.mappers.MemberMapper;
import com.padminisys.election.api.model.response.MemberResponse;
import com.padminisys.election.dal.entity.Member;
import com.padminisys.election.dal.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("member")
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;
    private final HouseService houseService;

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

    @RolesAllowed("admin")
    @GetMapping("/fetch")
    public @ResponseBody
    MemberResponse getMember(@RequestParam(required = false) Optional<Long> id, @RequestParam(required = false) Optional<String> name) throws ObjectNotFoundException {
        if (id.isPresent()) {
            return getMemberResponse(memberRepository.findById(id.get()));
        } else if (name.isPresent()) {
            return getMemberResponse(memberRepository.findMemberByName(name.get()));
        }
        throw new ObjectNotFoundException("Valid request parameter not provided.");
    }

    private MemberResponse getMemberResponse(Optional<Member> optionalMember) throws ObjectNotFoundException {
        if (optionalMember.isPresent()) {
            Member member = optionalMember.get();
            MemberResponse memberResponse = memberMapper.MemberToMemberResponse(member);
            try {
                memberResponse.setHouse(houseService.getHouse(Optional.of(member.getHouse().getId()), Optional.empty()));
            } catch (ObjectNotFoundException e) {
                log.error("Member {} doesn't have house details attached.", member.getName());
            }
            return memberResponse;
        }
        throw new ObjectNotFoundException("Valid request parameter not provided.");
    }
}