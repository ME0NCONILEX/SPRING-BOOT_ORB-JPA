package se.me0nly.myJpaOrm1a2.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appUserId;
    @Column(unique = true)
    private String username;
    private String password;
    private LocalDate regDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id", table = "app_user")
    private About userAbout;

    public AppUser(int appUserId, String username, String password, LocalDate regDate, About userAbout) {
        this.appUserId = appUserId;
        this.username = username;
        this.password = password;
        this.regDate = regDate;
        this.userAbout = userAbout;
    }

    public AppUser() {
    }

    public int getAppUserId() {
        return appUserId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public About getUserDetails() {
        return userAbout;
    }

    public void setUserDetails(About userAbout) {
        this.userAbout = userAbout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return appUserId == appUser.appUserId && Objects.equals(regDate, appUser.regDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appUserId, regDate);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "appUserId=" + appUserId +
                ", regDate=" + regDate +
                '}';
    }
}
