package ru.kuranov.dogwalk.model.entity.comment;


import lombok.*;
import ru.kuranov.dogwalk.model.entity.main.Owner;
import ru.kuranov.dogwalk.model.entity.main.Walker;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "walkers_comment")
public class WalkersComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "walker_id")
    private Walker author;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner recipient;

    @Column(name = "message", length = 2048)
    private String message;
}
