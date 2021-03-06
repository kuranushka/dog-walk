package ru.kuranov.dogwalk.model.entity.main;

import lombok.*;
import ru.kuranov.dogwalk.model.entity.comment.OwnersComment;
import ru.kuranov.dogwalk.model.entity.comment.WalkersComment;
import ru.kuranov.dogwalk.model.entity.security.AccountUser;
import ru.kuranov.dogwalk.model.entity.security.Role;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "owner")
public class Owner extends AccountUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Singular
    @ManyToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinTable(name = "owner_role",
            joinColumns = @JoinColumn(name = "owner_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "mail")
    private String mail;

    @Column(name = "phone")
    private String phone;

    @OneToMany(targetEntity = Dog.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "owner")
    private Set<Dog> dogs;

    @OneToMany(targetEntity = Walking.class,
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY,
            mappedBy = "owner")
    private Set<Walking> walkings;

    @OneToMany(targetEntity = OwnersComment.class,
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY,
            mappedBy = "author")
    private Set<OwnersComment> ownersComments;

    @OneToMany(targetEntity = WalkersComment.class,
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY,
            mappedBy = "recipient")
    private Set<WalkersComment> walkersComments;

    @Column(name = "rating")
    private int rating;
}
