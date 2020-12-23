##Booking API with Basic Authorization/Authentication 
###all-in-memory version (v2)

####Credentials for basic authorization
- Role:
  - admin - allows to fulfil all ``CRUD`` operations:
    - username: admin
    - password: admin

![postman_admin_admin](https://user-images.githubusercontent.com/60865783/103043463-ee217a80-454a-11eb-87e9-4040dbeb8a00.png)

    
  - user - allows to read data only  
    - username: user
    - password: user
    



``Get`` all bookings details from http://localhost:8080/v2/api/booking/
- request returns details of all bookings that exist within the API

````
HTTP/1.1 200 OK

[
{
"booking_id": 1,
"name": "Hong",
"lastname": "Wintheiser",
"price": 511.45,
"paid": true,
"city": "Port Sammiemouth",
"languages": [
"English",
"German",
"French"
],
"booking_dates": {
"checkIn": "2020-12-09",
"checkOut": "2020-12-23"
},
"additional_needs": "n/a"
},

...

{
"booking_id": 15,
"name": "Pearly",
"lastname": "Casper",
"price": 889.84,
"paid": true,
"city": "Shariceville",
"languages": [
"English",
"German",
"French"
],
"booking_dates": {
"checkIn": "2020-12-13",
"checkOut": "2021-01-06"
},
"additional_needs": "Breakfast"
}
]
````

``Get`` one booking details by `id` http://localhost:8080/v2/api/booking/id
- request returns details of a single booking that exist within the API
````
HTTP/1.1 200 OK

{
"booking_id": 1,
"name": "Hong",
"lastname": "Wintheiser",
"price": 511.45,
"paid": true,
"city": "Port Sammiemouth",
"languages": [
"English",
"German",
"French"
],
"booking_dates": {
"checkIn": "2020-12-09",
"checkOut": "2020-12-23"
},
"additional_needs": "n/a"
}
  ````
``POST`` adds one booking details http://localhost:8080/v2/api/booking/
- request adds single booking to the list of bookings within the API

````
HTTP/1.1 200 OK

{
        "name": "Toske",
        "lastname": "Smulkisnes",
        "provider": "Afina",
        "amount": 899.34,
        "duration": {
            "begin_date": "2020-01-15",
            "end_date": "2020-12-14"
        },
        "additional_coverage": "Eyes"
    }
````    

``DELETE`` removes one booking details by ``id`` http://localhost:8080/v2/api/booking/id
- request deletes one booking from the list of bookings within the API

``HTTP/1.1 200 OK``
