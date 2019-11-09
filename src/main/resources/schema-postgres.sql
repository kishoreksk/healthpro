DROP TABLE IF EXISTS pharmacy;
CREATE TABLE pharmacy(id serial PRIMARY KEY, name VARCHAR(255),city VARCHAR(100));

DROP TABLE IF EXISTS doctorsprofile;
CREATE TABLE doctorsprofile(id serial PRIMARY KEY, name VARCHAR(255),type VARCHAR(100), speciality VARCHAR (100));


DROP TABLE IF EXISTS patientsrecord;
CREATE TABLE patientsrecord(id serial PRIMARY KEY, name VARCHAR(255),gender VARCHAR(100), age VARCHAR (100), address VARCHAR (100), disease VARCHAR (100), admission VARCHAR (100), discharge VARCHAR (100),bloodgroup VARCHAR (100),drug_name VARCHAR (100),drug_type VARCHAR (100),dose VARCHAR (100),dosage VARCHAR (100) );


DROP TABLE IF EXISTS appointment;
CREATE TABLE appointment(id serial PRIMARY KEY,name VARCHAR(255), age VARCHAR(100), gender VARCHAR (100), address VARCHAR (100), contact VARCHAR (100), doctor VARCHAR (100), disease VARCHAR (100), date VARCHAR(100), time VARCHAR(100));

DROP TABLE IF EXISTS medications;
CREATE TABLE medications(drug_id serial PRIMARY KEY,drug_name VARCHAR(255),drug_type VARCHAR (100), dose VARCHAR (100), dosage VARCHAR (100));
