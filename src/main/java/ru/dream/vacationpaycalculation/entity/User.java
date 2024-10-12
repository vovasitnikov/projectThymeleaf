package ru.dream.vacationpaycalculation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "users",
        uniqueConstraints = {
            @UniqueConstraint(name = "uniqEmail", columnNames = "email"),
                @UniqueConstraint(name = "uniqLogin", columnNames = "login"),
        })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @SequenceGenerator(name = "pet_seq",
            sequenceName = "pet_sequence",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "pet_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    //@Column(name = "last_name", nullable = false)
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "login")
    private String login;

    @Column(name = "position")
    private String position;

    @Column(name = "email")
    private String email;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "salary")
    private Integer salary;
}
