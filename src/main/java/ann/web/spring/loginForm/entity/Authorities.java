package ann.web.spring.loginForm.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "authorities")
public class Authorities {
    @Id
    @Column(name = "authority")
    private String authority;

    @ManyToOne
    @JoinColumn(name = "name")
    private User user;

    public String getAuthority() {
        return authority;
    }

    public Authorities(){}

    public Authorities(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authorities that = (Authorities) o;
        return Objects.equals(authority, that.authority) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authority, user);
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
