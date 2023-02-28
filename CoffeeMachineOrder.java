package coffeeMachine;

public class CoffeeMachineOrder {
private DrinkType drink;
private double amount;
private static  double balance;
private int sugar;
private boolean isHot;
private boolean touillette;
private String message;


private CoffeeMachineOrder(CoffeeMachineOrderBuilder builder) {
	this.drink=builder.drink;
	this.amount=builder.amount;
	CoffeeMachineOrder.balance=builder.balance;
	this.sugar=builder.sugar;
	this.touillette=builder.touillette;
	this.message=builder.message;
	this.isHot=builder.isHot;		
}
public String toString() {
	String s = null;
	if (this.sugar>=1 && (this.drink==DrinkType.TEA || this.drink==DrinkType.COFFEE || this.drink==DrinkType.HOT_CHOCOLATE)&& this.isHot==true) {
	s= "Your drink is: "+this.drink +" it has "+this.sugar+" sugar, a stick,it is extra hot, and it cost you "+this.amount+ " you still have "+(this.balance-this.amount)+ " in your balance.";
	}
	else if (this.sugar>=1 && (this.drink==DrinkType.TEA || this.drink==DrinkType.COFFEE || this.drink==DrinkType.HOT_CHOCOLATE)&& this.isHot==false){
		s= "Your drink is: "+this.drink +" it has "+this.sugar+" sugar, a stick,it is extra hot, and it cost you "+this.amount+ " you still have "+(this.balance-this.amount)+ " in your balance.";
	}
	else if(this.sugar==0 && (this.drink==DrinkType.TEA || this.drink==DrinkType.COFFEE || this.drink==DrinkType.HOT_CHOCOLATE)&& this.isHot==false) {
		s="Your drink is: "+this.drink +" it has no sugar, no stick, and it costs you "+this.amount+ " you still have "+(this.balance-this.amount)+ " in your balance.";
	}
	else if(this.sugar==0 && (this.drink==DrinkType.TEA || this.drink==DrinkType.COFFEE || this.drink==DrinkType.HOT_CHOCOLATE)&& this.isHot==true) {
		s="Your drink is: "+this.drink +" it has no sugar, no stick, it is extra hot and it costs you "+this.amount+ " you still have "+(this.balance-this.amount)+ " in your balance.";
	}
	else if (this.sugar==0 && this.drink==DrinkType.ORANGE_JUICE) {
		s="Your drink is: "+this.drink +" it has no sugar, no stick,and it costs you "+this.amount+ " you still have "+(this.balance-this.amount)+ " in your balance.";
	}else if(this.sugar>=1 && this.drink==DrinkType.ORANGE_JUICE) {
			s="Your drink is: "+this.drink +" it has "+this.sugar+" sugar, a stick,and it costs you "+this.amount+ " you still have "+(this.balance-this.amount)+ " in your balance.";
		}
	else {
		s="Your message is: "+ this.message;
	}
	
	
	return s;}
public static double getBalance() {
	return balance;
}
public static double calculatePrice(DrinkType drink) {
    double price;

    switch (drink) {
        case TEA:
        
            price = 50;
            break;
        case HOT_CHOCOLATE:
        	
            price = 60;
            break;
        case COFFEE:
        
            price = 70;
            break;
        case ORANGE_JUICE:
        
        	price = 80;
        	break;
        default:
            throw new IllegalArgumentException("Invalid drink type: " + drink);
    }
    return price;
}
public static class CoffeeMachineOrderBuilder{
	private boolean isHot;
	private DrinkType drink;
	private double amount;
	private double balance;
	private int sugar;
	private boolean touillette;
	private String message;

	public CoffeeMachineOrderBuilder(DrinkType drink, double amount, double balance, String message, boolean touillette, int sugar, boolean isHot) {
		this.drink=drink;
		this.amount=amount;
		this.balance=balance;
		this.sugar=sugar;
		this.touillette=touillette;
		this.message=message;
		this.isHot=isHot;
	}
	public CoffeeMachineOrderBuilder() {
		// TODO Auto-generated constructor stub
	}
	public CoffeeMachineOrderBuilder setAmount(double amount) {
		this.amount=amount;
		return this;
	}
	public CoffeeMachineOrderBuilder setBalance(double balance) {
		this.balance=balance;
		return this;
	}
	public CoffeeMachineOrderBuilder setDrink(DrinkType drink) {
		this.drink=drink;
		return this;
	}
	public CoffeeMachineOrderBuilder setTouillete(boolean touillette) {
		this.touillette=touillette;
		return this;
	}
	public CoffeeMachineOrderBuilder setSugar(int sugar) {
		this.sugar=sugar;
		return this;
	}
	public CoffeeMachineOrderBuilder setMessage(String message) {
		this.message=message;
		return this;
	}
	public CoffeeMachineOrderBuilder setExtraHot(boolean isHot) {
		this.isHot=isHot;
		return this;
	}
	public CoffeeMachineOrder build(){
		return new CoffeeMachineOrder(this);
	}
	}

}


