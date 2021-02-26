package by.realovka.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;
@EqualsAndHashCode(exclude = "teams")
@ToString(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@DiscriminatorValue("hockey player")
public class HockeyPlayer extends MemberTeam{
    private String amplua;
    private Integer weight;
    private Integer height;
    @ManyToMany(mappedBy = "players")
    private Set<Team> teams;
}
