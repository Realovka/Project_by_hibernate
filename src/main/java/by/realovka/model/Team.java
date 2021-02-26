package by.realovka.model;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;
@EqualsAndHashCode(exclude = {"assistants", "players"})
@ToString(exclude = {"assistants", "players"})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne(mappedBy = "team")
    private HeadCoach headCoach;
    @OneToMany(mappedBy = "team")
    private Set<AssistantHeadCoach> assistants = new LinkedHashSet<>();
    @ManyToMany
    @JoinTable(
            name = "team_hockey_player",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "hockey_player_id")
    )
    private Set<HockeyPlayer> players = new LinkedHashSet<>();

}
