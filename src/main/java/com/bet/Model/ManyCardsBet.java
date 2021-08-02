package com.bet.Model;

import java.util.Date;

import com.bet.Model.Enums.BetType;

public class ManyCardsBet extends Bet{

    private final int cardNumbersQuantity = 6;
    private int cardsQuantity;
    private int[][] numbers = new int[cardsQuantity][cardNumbersQuantity];

    public ManyCardsBet(BetType type, String[] bettors, Date date,int cardsQuantity, int[][] numbers) {
        super(type, bettors, date);
        type = BetType.Manycards;
        this.cardsQuantity = cardsQuantity;
        this.numbers = numbers;
    }

    public int getCardNumbersQuantity() {
        return this.cardNumbersQuantity;
    }

    public int getCardsQuantity() {
        return this.cardsQuantity;
    }

    public void setCardsQuantity(int cardsQuantity) {
        this.cardsQuantity = cardsQuantity;
    }

    public int[][] getNumbers() {
        return this.numbers;
    }

    public void setNumbers(int[][] numbers) {
        this.numbers = numbers;
    }
}
