package com.geektext.bookstore.profile;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long profile_id;
    private String username;
    private String password;
    private String full_name;
    private String email;
    private String home_address;

    @OneToMany(targetEntity = Card.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "pc_fk",referencedColumnName = "profile_id")
    private List<Card> creditCards;
    
    public Profile() { }
    
    public Profile(String username, String password, String full_name, String email, 
                    String home_address, List<Card> creditCards) {
        this.username = username;
        this.password = password;
        this.full_name = full_name;
        this.email = email;
        this.home_address = home_address;
        this.creditCards = creditCards;
    }

    public Profile(Long profile_id, String username, String password, String full_name, 
                    String email, String home_address, List<Card> creditCards) {
        this.profile_id = profile_id;
        this.username = username;
        this.password = password;
        this.full_name = full_name;
        this.email = email;
        this.home_address = home_address;
        this.creditCards = creditCards;
    }

    public Long getProfile_Id() {
        return profile_id;
    }

    public void setProfile_Id(Long profile_id) {
        this.profile_id = profile_id;
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

    public String getFullName() {
        return full_name;
    }

    public void setFullName(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomeAddress() {
        return home_address;
    }

    public void setHomeAddress(String home_address) {
        this.home_address = home_address;
    }

    @Column
    @ElementCollection
    public List<Card> getCreditCards(){
        return creditCards;
    }

    public void inputNewCard(String cNumber){
        Card creditCard = new Card(cNumber);
        creditCards.add(creditCard);
    }

    @Override
    public String toString() {
        return "User{" 
                + "profile_id=" + profile_id 
                + ", username=" + username 
                + ", password=" + password 
                + ", full_name=" + full_name 
                + ", email=" + email 
                + ", home_address=" + home_address + '}';
    }
    
    //just use string for it instead of creating a whole new entity?
}
