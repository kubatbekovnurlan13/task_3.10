package kg.kubatbekov.university_cms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "professors")
@Getter
@Setter
@NoArgsConstructor
public class Professor {
    @Id
    @Column(name = "professor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int professorId;

    @Column(name = "professor_name")
    private String professorName;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, mappedBy = "professors", fetch = FetchType.EAGER)
    private List<Subject> subjects;

    @OneToMany(mappedBy = "professor")
    private List<Lesson> lessons;

    public Professor(int professorId, String professorName) {
        this.professorId = professorId;
        this.professorName = professorName;
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
        Professor professor = (Professor) o;
        return professorId == professor.professorId && Objects.equals(professorName, professor.professorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(professorId, professorName);
    }
}
