package pendzu.sduteam.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 64)
    private String name;

    @NotBlank
    @Size(min = 3, max = 64)
    private String username;

    @NaturalId
    @NotBlank
    @Email
    @Size(max = 64)
    private String email;

//    @JsonIgnore
    @NotBlank
    @Size(min = 6, max = 128)
    private String password;

//    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @Lob
    private String avatar;

    @Lob
    private String blobString;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;

    private int status = 1;

    public User() {
    }

    public User(@NotBlank @Size(min = 3, max = 64) String name, @NotBlank @Size(min = 3, max = 64) String username, @NotBlank @Email @Size(max = 64) String email, @NotBlank @Size(min = 6, max = 128) String password, Set<Role> roles) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public User(@NotBlank @Size(min = 3, max = 64) String name, @NotBlank @Size(min = 3, max = 64) String username, @NotBlank @Email @Size(max = 64) String email, @NotBlank @Size(min = 6, max = 128) String password, Set<Role> roles, int status) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.status = status;
    }

    public User(@NotBlank @Size(min = 3, max = 64) String name, @NotBlank @Size(min = 3, max = 64) String username, @NotBlank @Email @Size(max = 64) String email, @NotBlank @Size(min = 6, max = 128) String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBlobString() {
        return blobString;
    }

    public void setBlobString(String blobString) {
        this.blobString = blobString;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

//    public String getMonth() {
//        return month;
//    }
//
//    public void setMonth(String month) {
//        this.month = month;
//    }
//
//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }
}
