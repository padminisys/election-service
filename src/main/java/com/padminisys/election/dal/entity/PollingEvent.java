package com.padminisys.election.dal.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"pollingNominations", "pollParticipants"})
public class PollingEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "electionEventId", referencedColumnName = "id", nullable = false)
    private ElectionEvent electionEvent;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pollingEvent", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PollingNomination> pollingNominations;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pollingEvent", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PollParticipant> pollParticipants;

    private Boolean isVoid;

    private LocalDateTime creationTime;
    private LocalDateTime updateTime;
    private String createdBy;
    private String modifiedBy;
}
