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
    @Column(name = "id")
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_generator")
    //@SequenceGenerator(name = "user_seq_generator", sequenceName = "user_seq", allocationSize = 1)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "position")
    private String position;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "salary")
    private Integer salary;
}
