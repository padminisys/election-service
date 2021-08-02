package com.padminisys.election.dal.entity;

import com.padminisys.election.dal.entity.constant.ApprovalStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(exclude = "pollParticipants")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //todo consider removing this when username and email is same
    @Column(nullable = false, unique = true)
    private String username;

    private String name;
    private String mobile;
    private String email;
    private String unit;
    private String address;
    private String aadhar;
    private String pan;
    private String photoKey;
    private ApprovalStatus status;
    private String userId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "houseId", referencedColumnName = "id", nullable = false)
    private House house;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "member", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<PollParticipant> pollParticipants;

    private LocalDateTime creationTime;
    private LocalDateTime updateTime;
    private String createdBy;
    private String modifiedBy;

}