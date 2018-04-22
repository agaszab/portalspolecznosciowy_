package com.example.zaj261.mod;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private boolean enabled;

    private String firstName;
    private String lastName;
    private String email;
    @Lob // pole większe niż zwykły varchar(255) czyli typu text
    private String img;

   // @OneToMany
  //  @JoinColumn(name = "id", referencedColumnName = "id")
  //  private List<Friends> friends;

  //  @OneToMany
  //  @JoinColumn(name = "id", referencedColumnName = "id")
  //  private List<Friends> invited;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

 //   public List<Friends> getInvited() {
 //       return invited;
 //   }

 //   public void setInvited(List<Friends> invited) {
 //       this.invited = invited;
 //   }

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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

  //  public List<Friends> getFriends() {
  //      return friends;
  //  }

  //  public void setFriends(List<Friends> friends) {
 //       this.friends = friends;
 //   }


}