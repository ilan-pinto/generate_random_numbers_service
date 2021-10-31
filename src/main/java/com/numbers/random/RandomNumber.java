package com.numbers.random;

import javax.persistence.*;

@Entity
@Table(name = "random_number")
public class RandomNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int randNum;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNum() {
        return randNum;
    }

    public void setNum(int randNum) {
        this.randNum = randNum;
    }
}
