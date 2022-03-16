package ru.kuranov.dogwalk.model.entity.main;

import lombok.*;
import ru.kuranov.dogwalk.model.entity.addition.*;
import ru.kuranov.dogwalk.model.entity.location.WalkingPlace;
import ru.kuranov.dogwalk.model.entity.time.Schedule;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(targetEntity = Owner.class)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "name")
    private String name;

    @Column(name = "breed")
    private String breed;

    @Column(name = "age")
    private String age;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "weight")
    private int weight;

    @Column(name = "weight_group")
    @Enumerated(EnumType.STRING)
    private WeightGroup weightGroup;

    @Column(name = "documents")
    @Enumerated(value = EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<DogDocument> dogDocuments;

    @Column(name = "vet")
    private String vet;

    @Column(name = "injury_id")
    private String injury;

    @Column(name = "pulling_leash")
    @Enumerated(value = EnumType.STRING)
    private PullingLeash pullingLeash;

    @Column(name = "pick_up_from_ground")
    @Enumerated(value = EnumType.STRING)
    private PickUpFromGround pickUpFromGround;

    @Column(name = "pick_it_up")
    @Enumerated(value = EnumType.STRING)
    private PickItUp pickItUp;

    @Column(name = "fear")
    private String fear;

    @Column(name = "aggression")
    @Enumerated(value = EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Aggression> aggression;

    @Column(name = "is_go_without_leash")
    private boolean isGoWithoutLeash;

    @Column(name = "is_interact_with_other_dogs")
    private boolean isInteractWithOtherDogs;

    @Column(name = "wash_paws")
    @Enumerated(value = EnumType.STRING)
    private WashPaws washPaws;

    @Column(name = "feed")
    private String feedAfterWalk;

    @Column(name = "walking_period")
    private int walkingPeriod;

    @OneToOne(targetEntity = Schedule.class,
            cascade = CascadeType.ALL,
            optional = false)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @Column(name = "meeting_to_walker")
    @Enumerated(value = EnumType.STRING)
    private MeetingToWalker meetingToWalker;

    @Column(name = "how_get_keys")
    @Enumerated(value = EnumType.STRING)
    private HowGetKeys howGetKeys;

    @Column(name = "addition_info", length = 1024)
    private String additionInfo;

    @Column(name = "walking_place")
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "dog")
    private Set<WalkingPlace> walkingPlace;

    @Column(name = "price")
    private int price;
}
