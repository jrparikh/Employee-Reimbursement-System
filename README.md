# Employee-Reimbursement-System
The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.

## Design Patterns:
* DAO 
* Front Controller

## Overview:
* Designed a normalized RDS designed to optimize data access and performance.
* Constructed Procedures, Triggers, and Sequences for inserting new users and reimbursements.
* Developed segregated data and service layers in Java based on data roles, e.g. Users and Reimbursements.
* Integrated Front Controller design pattern for request handling and response.
* Provided security by using HTTP session variables that maintain user role information.
* Created a responsive UI using HTML, CSS, and JavaScript.
* Interacted with the server asynchronously using AJAX.
* Utilized Bootstrap to improve the overall look and feel of the front-end.
