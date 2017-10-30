package domainmodel;

import java.io.Serializable;

public class User implements Serializable {

    private String username;
    private String password;
    private String email;
    private int active;
    private String firstname;
    private String lastname;

    public User() {

    }

    public User(String username, String password, String email, int active, String firstname, String lastname) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.active = active;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public User(String username, String password, String email, int active) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.active = active;
        firstname = "";
        lastname = "";
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.active = 1;
        firstname = "";
        lastname = "";
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
