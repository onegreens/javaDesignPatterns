CREATE DATABASE leetcode_repeat;

create table Employee (  Id INT (2 )  PRIMARY KEY, Salary INT (4 ) );
insert into Employee values (1,100),(2,200),(3,300) ;


create table Orders (  Id INT (1 )  PRIMARY KEY, CustomerId INT (1 ) );
insert into Orders values (1,3),(2,1) ;
create table Customers (  Id INT (1 )  PRIMARY KEY, Name VARCHAR (5 ) );
insert into Customers values (1,"Joe"),(2,"Henry"),(3,"Sam"),(4,"Max") ;

create table Person (  Id INT (1 )  PRIMARY KEY, Email VARCHAR (16 ) );
insert into Person values (1,"john@example.com"),(2,"bob@example.com"),(3,"john@example.com") ;