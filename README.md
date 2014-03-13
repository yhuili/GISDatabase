GISDatabase
===========

###This is a USC CSCI585 HW Repo

A spatial database system built by oracle and Java to keep tracking the location of wireless access-point and people who covered by wireless internet access.

**Instruction to Compile:**


1.  created.sql is the file to create tables and index of the spatial database. dropdb.sql is the file to delete tables and index.

2.	Populate.java
    
    2.1	Before compiling Populate.java, please change the information in config.properties corresponding to the database connection configuration, the parameter order is host, port, dbname username, password.

    2.2	Compile: Populate.java with classes12.jar and sdoapi.jar in Oracle lib
	
	2.3	Run: Populate config.properties building.xy people.xy ap.xy with classes12.jar and sdoapi.jar 

3.	Please put map.jpg to the same folder with ImageJPanel.java, hw2_HuiLi.java.
	
	3.1	Before compiling Populate.java, please change the information in config.properties corresponding to the database connection configuration, the parameter order is host, port, dbname, username, password.
	
	3.2	Compile: hw2_HuiLi.java ImageJPanel.java with classes12.jar and sdoapi.jar in Oracle lib
	
	3.3	Run: hw2_HuiLi config.properties with classes12.jar and sdoapi.jar 


The detailed description of the functionality is written with comments in the code.
