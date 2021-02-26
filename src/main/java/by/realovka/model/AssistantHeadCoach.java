package by.realovka.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@ToString(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@DiscriminatorValue("assistant head coach")
public class AssistantHeadCoach extends MemberTeam{
    @Column(name = "work_assistant_years")
    private Integer workAssistantYears;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}
