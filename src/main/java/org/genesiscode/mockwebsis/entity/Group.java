package org.genesiscode.mockwebsis.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "groups")
public class Group {

    @Id
    private String id;

    private Integer numberOfStudent;

    @Transient
    @ManyToMany(mappedBy = "groups")
    private Set<Subject> subjects = new HashSet<>();

    public Group(String id, Integer numberOfStudent) {
        this.id = id;
        this.numberOfStudent = numberOfStudent;
    }
}
