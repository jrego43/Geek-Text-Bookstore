package com.geektext.bookstore.profile;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long card_id;
    private String cNumber;

    public Card() {
    }

    public Card(String cNumber){
        this.cNumber = cNumber;
    }

    public void setCreditCardNumber(String cNumber){
        this.cNumber = cNumber;
    }

    public Long getCard_Id(){
        return card_id;
    }

    public String getCreditCardNumber(){
        return cNumber;
    }

}
