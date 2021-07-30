package com.bet.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.bet.Model.Enums.BetType;

public class Bet {
    private BetType type;
    private String[] bettors;
    private Date date;
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Bet(BetType type, String[] bettors, Date date) {
        this.type = type;
        this.bettors = bettors;
        this.date = date;
    }
    
    public BetType getType() {
        return this.type;
    }

    public String[] getBettors() {
        return this.bettors;
    }

    public void setBettors(String[] bettors) {
        this.bettors = bettors;
    }

    public String getDate() {
        return simpleDateFormat.format(this.date);
    }
}