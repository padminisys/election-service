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
@EqualsAndHashCode(exclude = {"members", "electionEvents"})
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "house", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Member> members;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "house", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ElectionEvent> electionEvents;

    private LocalDateTime creationTime;
    private LocalDateTime updateTime;
    private String createdBy;
    private String modifiedBy;

}
