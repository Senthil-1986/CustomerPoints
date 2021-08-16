# CustomerPoints
# To find the customers point of each month

# To Execute, Please download the PointCheck Folder

# # Open IDE and load this application (Maven and SpringBoot)

# Build and execute this application

# open Postman or browser and check this URL 'http://localhost:9009/point/process/list' 

# Response data

{
    "1": {
        "name": "Ram",
        "mobile": "8976544321",
        "address": "Mumbai",
        "id": 1,
        "pointMap": {
            "June": 0,
            "May": 0,
            "July": 49850
        },
        "invoices": [
            {
                "customerID": 1,
                "valueDate": "2021-07-16T04:30:12.000+0000",
                "amount": 25000.0
            },
            {
                "customerID": 1,
                "valueDate": "2021-04-30T18:29:59.000+0000",#Ignored because date is right before last 3 months
                "amount": 2000.0
            }
        ]
    },
    "2": {
        "name": "Rahul",
        "mobile": "8966544321",
        "address": "Delhi",
        "id": 2,
        "pointMap": {
            "June": 0,
            "May": 0,
            "July": 0
        },
        "invoices": [
            {
                "customerID": 2,
                "valueDate": "2021-08-06T04:30:12.000+0000",# Points not calculated because this month is ignored
                "amount": 25000.0
            }
        ]
    },
    "3": {
        "name": "Vidhya",
        "mobile": "8976544300",
        "address": "Pune",
        "id": 3,
        "pointMap": {
            "June": 0,
            "May": 49850,
            "July": 0
        },
        "invoices": [
            {
                "customerID": 3,
                "valueDate": "2021-04-30T18:30:01.000+0000",
                "amount": 25000.0
            }
        ]
    },
    "4": {
        "name": "Vijay",
        "mobile": "8976548821",
        "address": "Bangalore",
        "id": 4,
        "pointMap": {
            "June": 0,
            "May": 0,
            "July": 0
        },
        "invoices": [
            {
                "customerID": 4,
                "valueDate": "2021-04-30T18:29:59.000+0000",/# ignored because of old data (before last 3 months)
                "amount": 25000.0
            }
{
                "customerID": 1,
                "valueDate": "2021-04-30T18:29:59.000+0000",
                "amount": 2000.0
            }

        ]
    }
}
