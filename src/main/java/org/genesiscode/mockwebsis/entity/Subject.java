package org.genesiscode.mockwebsis.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @SequenceGenerator(name = "subject_sequence", sequenceName = "subject_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_sequence")
    private Long id;

    private String name;

    @Column(unique = true)
    private String code;

    @Enumerated(value = EnumType.STRING)
    private Semester semester;

    @ManyToMany(mappedBy = "subjects")
    private final Set<Teacher> teachers = new HashSet<>();

    @ManyToMany
    @JoinTable( name = "subjects_groups",
                joinColumns = @JoinColumn(name = "subject_id"),
                inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<Group> groups = new HashSet<>();

    public Subject(String name, String code, Semester semester) {
        this.name = name;
        this.code = code;
        this.semester = semester;
    }

    public void addGroup(Group group) {
        groups.add(group);
    }
}
