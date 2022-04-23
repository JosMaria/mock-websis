package org.genesiscode.mockwebsis.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @SequenceGenerator(name = "teacher_sequence", sequenceName = "teacher_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_sequence")
    private Long id;

    private String name;
    private String lastName;

    @Column(unique = true)
    private String email;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( name = "teachers_subjects",
                joinColumns = @JoinColumn(name = "teacher_id"),
                inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private final Set<Subject> subjects = new HashSet<>();

    public Teacher(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }
}
