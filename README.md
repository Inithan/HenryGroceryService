# HenryGroceryServiceV1

Please refer the following files:
----------------------------------

1). Henry Grocery Service Request and Response V1.txt

2). Swagger Link and API details V1.txt



SWAGGER LINK:
=============

http://localhost:8080/swagger-ui.html

Go To - Henry Controller

Provided 3 API:-
----------------

1). /getDiscounts  (Provides List of all Discounts)

[
  {
    "offer": "Buy 2 tins of soup and get a loaf of bread half price",
    "valid_from": -1,
    "valid_to": 7,
    "product": "soup",
    "discount_product": "bread",
    "discount_percentage": 50
  },
  {
    "offer": "Apples have a 10% discount",
    "valid_from": 3,
    "valid_to": -30,
    "product": "apples",
    "discount_product": "apples",
    "discount_percentage": 10
  }
]
--------------------------------------------------------------------------------
2). /getStockItems  (Provides List of all Stocks)

[
  {
    "product": "soup",
    "unit": "tin",
    "cost": 0.65
  },
  {
    "product": "bread",
    "unit": "loaf",
    "cost": 0.8
  },
  {
    "product": "milk",
    "unit": "bottle",
    "cost": 1.3
  },
  {
    "product": "apples",
    "unit": "single",
    "cost": 0.1
  }
]
--------------------------------------------------------------------------------

3).  /getPriceBasket (Provides Final-Price for the items in Basket)

Find the (Henry Grocery Service Request and Response V1.txt) for Request and respose for test cases too.


--------------------------------------------------------------------------------



------------------------------------------------------
NOTE: refer final_price for Price.
------------------------------------------------------
CASE 1:
=======
Price a basket containing: 3 tins of soup and 2 loaves of bread, bought today

Request:
--------
{
  "days": 0,
  "productDetails": [
 {
      "count": 2,
      "product": "bread"
    }
,
 {
      "count": 3,
      "product": "soup"
    }
  ]
}

Response:
---------
{
  "days": 0,
  "productDetails": [
    {
      "product": "bread",
      "count": 2
    },
    {
      "product": "soup",
      "count": 3
    }
  ],
  "discount_price": 0.4,
  "total_price": 3.5500000000000003,
  "final_price": 3.1500000000000004
}
##################Expected total cost = 3.15;

-----------------------------------------------------------------------------------------------------------------------


CASE 2:
=======
Price a basket containing: 6 apples and a bottle of milk, bought today,

Request:
--------
{
  "days": 0,
  "productDetails": [
 {
      "count": 6,
      "product": "apples"
    }
,
 {
      "count": 1,
      "product": "milk"
    }
  ]
}

Response:
---------

{
  "days": 0,
  "productDetails": [
    {
      "product": "apples",
      "count": 6
    },
    {
      "product": "milk",
      "count": 1
    }
  ],
  "discount_price": 0,
  "total_price": 1.9000000000000001,
  "final_price": 1.9000000000000001
}
####################Expected total cost = 1.90;

-----------------------------------------------------------------------------------------------------------------------
CASE 3:
=======
Price a basket containing: 6 apples and a bottle of milk, bought in 5 days time,

Request:
--------
{
  "days": 5,
  "productDetails": [
 {
      "count": 6,
      "product": "apples"
    }
,
 {
      "count": 1,
      "product": "milk"
    }
  ]
}
Response:
---------

{
  "days": 5,
  "productDetails": [
    {
      "product": "apples",
      "count": 6
    },
    {
      "product": "milk",
      "count": 1
    }
  ],
  "discount_price": 0.06000000000000001,
  "total_price": 1.9000000000000001,
  "final_price": 1.84
}

####################Expected total cost = 1.84;

-----------------------------------------------------------------------------------------------------------------------
CASE 4:
=======

Price a basket containing: 3 apples, 2 tins of soup and a loaf of bread, bought in 5 days time,

Request:
--------

{
  "days": 5,
  "productDetails": [
 {
      "count": 3,
      "product": "apples"
    }
,
 {
      "count": 1,
      "product": "bread"
    }
,
 {
      "count": 2,
      "product": "soup"
    }
  ]
}
Response:
---------
{
  "days": 5,
  "productDetails": [
    {
      "product": "apples",
      "count": 3
    },
    {
      "product": "bread",
      "count": 1
    },
    {
      "product": "soup",
      "count": 2
    }
  ],
  "discount_price": 0.43000000000000005,
  "total_price": 2.4000000000000004,
  "final_price": 1.9700000000000002
}
############Expected total cost = 1.97.

-----------------------------------------------------------------------------------------------------------------------
