DROP INDEX building_idx FORCE;
DROP INDEX people_idx FORCE;
DROP INDEX ap_idx FORCE;

DROP TABLE BUILDING;
DROP TABLE PEOPLE;
DROP TABLE AP;

DELETE FROM user_sdo_geom_metadata;