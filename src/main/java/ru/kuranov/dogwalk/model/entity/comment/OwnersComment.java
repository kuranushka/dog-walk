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
@Table(name = "owners_comment")
public class OwnersComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner author;

    @ManyToOne
    @JoinColumn(name = "walker_id")
    private Walker recipient;

    @Column(name = "message", length = 2048)
    private String message;

}
