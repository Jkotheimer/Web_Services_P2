# Web_Services_P2

## Compiling, Testing, and Running

- mvn clean compile
- mvn test
- mvn exec:java

## the structure

1) The buying experience

	- Search Product
	- Check availability
	- Buy process
	
		> Payment
		> Create order
		> Fulfill order
		> Ship order
		> Status (tracking)
		
			* Cancellation option
			* refund

2) Customer registration/ management

	- Add Customer
	
		> Update Customer profile
		> Add billing info
		
	- Delete Customer
	- Provide Status

3) Partner management

	- Add partner
	
		> Accept new products
		> Notify sales
		> Settle account (accept payment from buyer and pay seller)
		> Generate report
		
	- Delete partner

4) Communication among customers

	- Add reviews
