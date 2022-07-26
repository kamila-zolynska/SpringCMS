package pl.coderslab.author;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @Transient
    private String fullName;

    public String getFullName() {
        if (firstName.isEmpty() || lastName.isEmpty())
            return "Brak autora";
        return  firstName + " " + lastName;
    }
}
