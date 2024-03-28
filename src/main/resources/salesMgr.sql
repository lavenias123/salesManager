use salesSchema;
create database salesSchema;

drop Table if exists sales;

create Table sales (

	id_pk int unsigned Not Null, auto_increment,
	itemName varchar(45) Not Null,
	quantity int Not Null,
	amount float, Not Null,
	Primary Key(id_pk)
	);

Insert into sales (itemName, quantity, amount) 
	values 
		("One-Pot White Wine Pasta with Mushrooms and Leeks", 2, 32.50),
		("Pasta with Roasted Cauliflower and Crispy Capers", 3, 56.75),
		("Pulling-from-the-Pantry Puttanesca", 4, 89.99),
		("Linguine with Frenched Green Beans and Parsley Pesto", 2, 35.66),
		("Creamy Tomato Rigatoni", 7, 99.10),
		("Creamy Vegan Pasta with Greens, Peas, and Lemon Zest", 8, 108.99),
		("Pasta Aglio e Olio", 2, 15.89)
	;
