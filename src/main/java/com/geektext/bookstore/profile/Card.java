package com.geektext.bookstore.profile;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Card {
    private Integer cNumber;

    public Card() {
    }

    public Card(Integer cNumber){
        this.cNumber = cNumber;
    }

    public void setCreditCardNumber(Integer cNumber){
        this.cNumber = cNumber;
    }

    public Integer getCreditCardNumber(){
        return cNumber;
    }

}
