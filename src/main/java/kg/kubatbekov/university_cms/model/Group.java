package kg.kubatbekov.university_cms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "groups")
@Getter
@Setter
@NoArgsConstructor
public class Group {
    @Id
    @Column(name = "group_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int groupId;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "grade")
    private int grade;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "group_subject",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> subjects;

    @OneToMany(mappedBy = "group", fetch = FetchType.EAGER)
    private List<Student> students;

    @OneToMany(mappedBy = "group")
    private List<Lesson> lessons;

    public Group(int groupId, String groupName, int grade) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.grade = grade;
    }

    public int getGroupSize() {
        return students.size();
    }

    public List<Integer> getSubjectIds() {
        List<Integer> subjectIds = new ArrayList<>();

        subjects.forEach(subject -> subjectIds.add(subject.getSubjectId()));
        return subjectIds;
    }

    public String getSubjectsAsString() {
        StringBuilder subjectsAsString = new StringBuilder(" ");

        for (Subject subject : subjects) {
            subjectsAsString.append(subject.getSubjectName()).append(", ");
        }
        return subjectsAsString.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return groupId == group.groupId && grade == group.grade && Objects.equals(groupName, group.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, groupName, grade);
    }
}
