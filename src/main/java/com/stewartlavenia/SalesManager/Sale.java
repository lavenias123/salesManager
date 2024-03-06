package com.stewartlavenia.SalesManager;


//@Data can't be resolved to a type
public class Sale {
	private int id;
	private String ItemName;
	private int Quantity;
	private float Amount;
	

//	@Data
// generate super class constructor
//	public Sale(String string, int i, float f) {
	public Sale() {
	}

	public Sale(int id, String itemName, int quantity, float amount) {
		super();
		this.id = id;
		ItemName = itemName;
		Quantity = quantity;
		Amount = amount;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getItemName() {
		return ItemName;
	}


	public void setItemName(String itemName) {
		ItemName = itemName;
	}


	public int getQuantity() {
		return Quantity;
	}


	public void setQuantity(int quantity) {
		Quantity = quantity;
	}


	public float getAmount() {
		return Amount;
	}


	public void setAmount(float amount) {
		Amount = amount;
	}

	// generate toStr() to show details of the sale
	@Override
	public String toString() {
		return "Sale [id=" + id + ", ItemName=" + ItemName + ", Quantity=" + Quantity + ", Amount=" + Amount + "]";
	}
	

	
	
}
