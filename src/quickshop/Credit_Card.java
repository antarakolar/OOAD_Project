package QuickShop;

public class Credit_Card {
	private String cardName;
	private String address; 
	private int cardNumber;
	private int exMonth;
	private int cvv;
	public String getCardName(){
        return cardName;
    }

    public void setCardName(String cardName){
        this.cardName = cardName;
    }
    
    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }
    
    public int getCardNumber(){
        return cardNumber;
    }

    public void setCardNumber(int cardNumber){
        this.cardNumber = cardNumber;
    }
    
    public int getExMonth(){
        return exMonth;
    }

    public void setExMonth(int exMonth){
        this.exMonth = exMonth;
    }
    
    public int getCvv(){
        return cvv;
    }

    public void setCvv(int cvv){
        this.cvv = cvv;
    }

}
