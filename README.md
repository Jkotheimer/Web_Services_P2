# Project 2 Documentation
- Jack Kothemier
- Mohammed Rayyan Shaji
- Jack Broncato

## Main Classes:

- Utility
  - Contains utility functions as well as CRUD operations for Product, Buyer, Seller and Orders for service layer to use.

- Order
  - Represents an Order for a Product, contains Products ordered and a reference to the Buyer who made the Order.

- Product
  - Simply represents an item, Sellers have one to multiple Products attached to them, indicating they are the one selling them.

- Buyer
  - Represents a Customer, can create orders for products and contain basic info on themselves to aid in fulfilling orders.

- Seller
  - Represents a Supplier of items, has Products they sell and a home Address, as well as possibly Orders they must still fulfill.

- Address
  - Simple data object, just stores string fields to represent a real life address.

- PaymentInfo
  - Another simple data object, instead stores information needed to complete payment for an order.

## Technologies

We are using Mysql for creating our database tables and Hibernate for ORM mapping, it is still a work in progress with getting these to work the way we want.

### DataAccessLayer

- We’ve created a package of DataAccessLayer named ‘DAL’ which has all classes used for ORM Mapping. We’re configuring the details of our database connection in the hibernate.config.xml file. Each class is marked with an Entity annotation so that Hibernate recognises it as an entity. 

- We’re using Id annotation to mark the entry in the table as a primary key, and Column annotation which has the same name contained of the column in the database. 

- In our data access layer class, we are initiating a connection to the database using the SessionFactory class of Hibernate. We then create a new object of the type of the class and specify the values of it and make a commit to the current transaction which is how the values are inserted into the database.

###Manager Classes
We have Manager classes for each entity which contain methods for CRUD operations within them.

![Untitled Diagram-1](https://user-images.githubusercontent.com/26625500/65849453-37672800-e310-11e9-98b2-f0fc75645549.jpg)


