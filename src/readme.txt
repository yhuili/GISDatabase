Hui Li
USC-ID: 3194-8195-03
Email: hli997@usc.edu

This is a spatial database system built by oracle and Java to keep tracking the location of wireless access-point and people who covered by wireless internet access.

List of Submitted Files:
1.	createdb.sql
2.	dropdb.sql
3.	config.properties
4.	Populate.java 
5.	ImageJPanel.java
6.	hw2_HuiLi.java
7.	readme.txt

Instruction to Compile:
1.	created.sql is the file to create tables and index of the spatial database. dropdb.sql is the file to delete tables and index.
2.	Populate.java
(a)	Before compiling Populate.java, please change the information in config.properties corresponding to the database connection configuration, the parameter order is host, port, dbname, username, password.
(b)	Compile:
C:\Users\huili\workspace\OracleTest\databas>javac -classpath .;C:\oracle\product\10.2.0\db_1\jdbc\lib\classes12.jar;C:\oracle\product\10.2.0\db_1\md\lib\sdoapi.jar Populate.java
(c)	Run: 
C:\Users\huili\workspace\OracleTest\databas>java -classpath .;C:\oracle\product\10.2.0\db_1\jdbc\lib\classes12.jar;C:\oracle\product\10.2.0\db_1\md\lib\sdoapi.jar Populate config.properties building.xy people.xy ap.xy
3.	Please put map.jpg to the same folder with ImageJPanel.java, hw2_HuiLi.java.
(a)	Before compiling Populate.java, please change the information in config.properties corresponding to the database connection configuration, the parameter order is host, port, dbname, username, password.
(b)	Compile:
C:\Users\huili\workspace\OracleTest\database>javac -classpath .;C:\oracle\product\10.2.0\db_1\jdbc\lib\classes12.jar;C:\oracle\product\10.2.0\db_1\md\lib\sdoapi.jar hw2_HuiLi.java ImageJPanel.java
(c)	Run:
C:\Users\huili\workspace\OracleTest\database>java -classpath .;C:\oracle\product\10.2.0\db_1\jdbc\lib\classes12.jar;C:\oracle\product\10.2.0\db_1\md\lib\sdoapi.jar hw2_HuiLi config.properties

The detailed description of the functionality is written with comments in the code.
