public class uniqueCard extends Bet{

    private int cardNumbersQuantity;
    private int[] numbers = new int[cardNumbersQuantity] ;

    uniqueCard(BetType type, String[] bettors, Date date,int[] numbers, int cardNumbersQuantity){
        super(type, bettors, date);
        type=BetType.uniqueCard;
        this.numbers=numbers;
    }

    public int getCardNumbersQuantity() {
        return this.cardNumbersQuantity;
    }

    public void setCardNumbersQuantity(int cardNumbersQuantity) {
        this.cardNumbersQuantity = cardNumbersQuantity;
    }

    public int[] getNumbers() {
        return this.numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }
    
}