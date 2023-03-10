package se.me0nly.myJpaOrm1a2.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class About {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int detailsId;
    @Column(unique = true)
    private String email;
    private String name;
    private LocalDate birthDate;

    public About(int detailsId, String email, String name, LocalDate birthDate) {
        this.detailsId = detailsId;
        this.email = email;
        this.name = name;
        this.birthDate = birthDate;
    }

    public About() {
    }

    public int getDetailsId() {
        return detailsId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        About about = (About) o;
        return detailsId == about.detailsId && Objects.equals(email, about.email) && Objects.equals(name, about.name) && Objects.equals(birthDate, about.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(detailsId, email, name, birthDate);
    }

    @Override
    public String toString() {
        return "About{" +
                "detailsId=" + detailsId +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
