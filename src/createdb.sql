CREATE TABLE BUILDING(
	bID varchar2(10) NOT NULL,
	bName varchar2(50),
	bVertices NUMBER,
	bShape SDO_GEOMETRY,
	PRIMARY KEY (bID));



CREATE TABLE PEOPLE(
	pID varchar2(10) NOT NULL,
	pLocation SDO_GEOMETRY,
	PRIMARY KEY (pID));



CREATE TABLE AP(
	apID varchar2(10) NOT NULL,
	apLocation SDO_GEOMETRY,
	apRadius NUMBER,
	PRIMARY KEY (apID));



INSERT INTO user_sdo_geom_metadata(TABLE_NAME,COLUMN_NAME,DIMINFO,SRID) 
	VALUES (
	'BUILDING',
 	'bShape',
 	SDO_DIM_ARRAY(
 	SDO_DIM_ELEMENT('X', 0, 820, 0.005),
 	SDO_DIM_ELEMENT('Y', 0, 580, 0.005)),
  	NULL);



INSERT INTO user_sdo_geom_metadata(TABLE_NAME,COLUMN_NAME,DIMINFO,SRID) 
	VALUES (
	'PEOPLE',
 	'pLocation',
 	SDO_DIM_ARRAY(
 	SDO_DIM_ELEMENT('X', 0, 820, 0.005),
 	SDO_DIM_ELEMENT('Y', 0, 580, 0.005)),
  	NULL);



INSERT INTO user_sdo_geom_metadata(TABLE_NAME,COLUMN_NAME,DIMINFO,SRID) 
	VALUES (
	'AP',
 	'apLocation',
 	SDO_DIM_ARRAY(
 	SDO_DIM_ELEMENT('X', 0, 820, 0.005),
 	SDO_DIM_ELEMENT('Y', 0, 580, 0.005)),
  	NULL);



CREATE INDEX building_idx ON BUILDING(bShape) 
	INDEXTYPE IS MDSYS.SPATIAL_INDEX;

CREATE INDEX people_idx ON PEOPLE(pLocation) 
	INDEXTYPE IS MDSYS.SPATIAL_INDEX;

CREATE INDEX ap_idx ON AP(apLocation) 
	INDEXTYPE IS MDSYS.SPATIAL_INDEX;