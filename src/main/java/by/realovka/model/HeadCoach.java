package by.realovka.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@ToString(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@DiscriminatorValue("head coach")
public class HeadCoach extends MemberTeam {
    @Column(name = "work_chief_years")
    private Integer workChiefYears;
    @OneToOne
    @JoinColumn(name = "team_id")
    private Team team;

}
