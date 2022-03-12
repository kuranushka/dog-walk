package ru.kuranov.dogwalk.model.entity.addition;

import lombok.*;
import ru.kuranov.dogwalk.model.entity.dog.Dog;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "meeting_to_walker")
public class MeetingToWalker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "label")
    private String label;

    @ManyToOne
    @JoinColumn(name = "dog_id")
    private Dog dog;
}
