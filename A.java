public class A
{
    
    public static void main(String args[])/Users/sanjay.agnani/Downloads/FacebookReactRedux/README.md
    {
        System.out.println("A");
        
               
    }
}


	/Users/sanjay.agnani/Downloads/users.sql
Rahil Parikh	8:21 AM 19 August
https://www.tutorialspoint.com/testng/index.htm
https://www.tutorialspoint.com/json/index.htm
https://www.tutorialspoint.com/junit/index.htm
https://www.tutorialspoint.com/log4j/index.htm
https://www.tutorialspoint.com/maven/index.htm
https://www.tutorialspoint.com/servlets/index.htm
https://www.tutorialspoint.com/jsp/index.htm

http://www.studytonight.com/jsp/jsp-declaration-tag.php


21 Aug:
https://stackoverflow.com/questions/11707879/difference-between-scaling-horizontally-and-vertically-for-databases

http://blog.rdx.com/cassandra-and-relational-database-schema-comparison-query-vs-relationship-modeling/

Properties: /usr/local/etc/cassandra
Logs: /usr/local/var/log/cassandra
Data: /usr/local/var/lib/cassandra/data

CQLSH COMMANDS:

Cassandra Architecture:
https://academy.datastax.com/resources/brief-introduction-apache-cassandra
(Youtube Architecture/ Comparision with Hadoop Ecosystem)
https://www.youtube.com/watch?v=LKcIa5sxlKg
Cassandra Config file




Cassandra detailed Architecture	:

https://dzone.com/articles/introduction-apache-cassandras


IOC AND DI understanding

https://www.codeproject.com/Articles/592372/Dependency-Injection-DI-vs-Inversion-of-Control-IO

https://www.codeproject.com/Articles/29271/Design-pattern-Inversion-of-control-and-Dependency



Cluster And Session

String query = "CREATE TABLE sanjay(emp_id int PRIMARY KEY, "
		         + "emp_name text, "
		         + "emp_city text, "
		         + "emp_sal varint, "
		         + "emp_phone varint );";
		
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build(); 
		Session session = cluster.connect("cycling");
		
		session.execute(query);


CREATE KEYSPACE smsdb
WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};



CREATE TABLE student(std_id int PRIMARY KEY,std_name text,std_city text,std_age int,std_email varint;std_course text;std_marks int);







String query = "CREATE TABLE users(id int PRIMARY KEY, "
		         + "username text, "
		         + "firstname text, "
		         + "lastname text, "
		         + "email text, "
		         + "address text, "
			     + "password text, "
			     + "phone int );";
		

NSERT INTO sanjay(id,username,firstname,lastname,email,address,password,phone) VALUES(2,'sanjayaganani92','sanjay','Agnani','sanjagnani92gmail.com','Ahmedabad','1223','901486744');

	