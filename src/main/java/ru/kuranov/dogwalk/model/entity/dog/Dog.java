package ru.kuranov.dogwalk.model.entity.dog;

import lombok.*;
import ru.kuranov.dogwalk.model.entity.addition.HowGetPet;
import ru.kuranov.dogwalk.model.entity.addition.MeetingToWalker;
import ru.kuranov.dogwalk.model.entity.addition.WashPaws;
import ru.kuranov.dogwalk.model.entity.behavior.Aggression;
import ru.kuranov.dogwalk.model.entity.behavior.PickItUp;
import ru.kuranov.dogwalk.model.entity.behavior.PickUpFromGround;
import ru.kuranov.dogwalk.model.entity.behavior.PullingLeash;
import ru.kuranov.dogwalk.model.entity.location.WalkingPlace;
import ru.kuranov.dogwalk.model.entity.owner.Owner;
import ru.kuranov.dogwalk.model.entity.time.Schedule;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "dog")
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne(targetEntity = Owner.class)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "name")
    private String name;

    @Column(name = "breed")
    private String breed;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "weight")
    private int weight;

    @Column(name = "weight_group")
    @Enumerated(EnumType.STRING)
    private WeightGroup weightGroup;

    @Column(name = "documents")
    @OneToMany(targetEntity = DogDocument.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "dog")
    private Set<DogDocument> dogDocuments;

    @OneToOne(targetEntity = Vet.class,
            cascade = CascadeType.ALL,
            optional = false)
    @JoinColumn(name = "vet_id")
    private Vet vet;

    @Column(name = "injury_id")
    private String injury;

    @Column(name = "pulling_leash")
    @OneToMany(targetEntity = PullingLeash.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "dog")
    private Set<PullingLeash> pullingLeash;

    @Column(name = "pick_up_from_ground")
    @OneToMany(targetEntity = PickUpFromGround.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "dog")
    private Set<PickUpFromGround> pickUpFromGround;

    @Column(name = "pick_it_up")
    @OneToMany(targetEntity = PickItUp.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "dog")
    private Set<PickItUp> pickItUp;

    @Column(name = "fear")
    private String fear;

    @Column(name = "aggression")
    @OneToMany(targetEntity = Aggression.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "dog")
    private Set<Aggression> aggression;

    @Column(name = "is_go_without_leash")
    private boolean isGoWithoutLeash;

    @Column(name = "is_interact_with_other_dogs")
    private boolean isInteractWithOtherDogs;

    @Column(name = "is_wash_paws")
    private boolean isWashPaws;

    @Column(name = "wash_paws")
    @OneToMany(targetEntity = WashPaws.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "dog")
    private Set<WashPaws> washPaws;

    @Column(name = "feed_after_walk")
    private boolean isFeedAfterWalk;

    @Column(name = "feed")
    private String feed;

    @Column(name = "portion")
    private String portion;

    @Column(name = "walking_period")
    private int walkingPeriod;

    @OneToOne(targetEntity = Schedule.class,
            cascade = CascadeType.ALL,
            optional = false)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @Column(name = "meeting_to_walker")
    @OneToMany(targetEntity = WashPaws.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "dog")
    private Set<MeetingToWalker> meetingToWalker;

    @Column(name = "how_get_pet")
    @OneToMany(targetEntity = WashPaws.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "dog")
    private Set<HowGetPet> howGetPet;

    @Column(name = "addition_info", length = 1024)
    private String additionInfo;

    @Column(name = "walking_place")
    @OneToMany(targetEntity = WashPaws.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "dog")
    private Set<WalkingPlace> walkingPlace;
}
