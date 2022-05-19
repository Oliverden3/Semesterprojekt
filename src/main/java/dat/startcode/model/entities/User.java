package dat.startcode.model.entities;

import java.util.Objects;

public class User
{
    private int user_id;
    private String username;
    private String password;
    private String role;
    private int balance;
    private String email;
    private String address;
    private String phone;

    public User(String username, String password, String email, String role, int balance)
    {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.balance = balance;
    }

    public User (String username, String password, String email, String address, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = "user";
        this.balance = 500;
        this.address = address;
        this.phone = phone;
    }



    @Override
    public String toString()
    {
        return "User{" +
                "brugerNavn='" + username + '\'' +
                ", kodeord='" + password + '\'' +
                ", rolle='" + role + '\'' +
                '}';
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUsername().equals(user.getUsername()) && getPassword().equals(user.getPassword()) &&
                getRole().equals(user.getRole());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getUsername(), getPassword(), getRole());
    }
}