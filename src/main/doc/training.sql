
drop database if exists  trainingdb ;
create database trainingdb;
use trainingdb;

CREATE TABLE Student( 
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
  email VARCHAR(500),
  name VARCHAR(500),
  password VARCHAR(500)
);

Create TABLE Event(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
  title VARCHAR(500),
  type char(1),
  startDate DATE,
  course_duration int,
  seminar_price int
);

Create TABLE Event_Delegate(
  student_id INT NOT NULL,
  event_id INT NOT NULL,
  foreign key (student_id) references Student(id),
  foreign key (event_id) references Event(id)
);

insert into Event (title,type,startDate, course_duration) VALUES ("Java for the Brave","C","2013-01-12",4 ),("Python for Java Developers","C","2013-02-17",3 ),("Scala for JavaScript programmers","C","2013-07-26",5 );

insert into Event (title,type,startDate, seminar_price) VALUES ("Java Performance","S","2013-06-12",3 ),("Web Application Development with Scala","S","2013-10-20",8 ),("Introduction to Jython","S","2013-04-11",1 );

