INSERT INTO pharmacy(name,city) VALUES ('Costco','Fremont');
INSERT INTO pharmacy(name,city) VALUES ('Walgreen','New York');
INSERT INTO pharmacy(name,city) VALUES ('CVS','Washington');
INSERT INTO pharmacy(name,city) VALUES ('Walmart','Chicago');


INSERT INTO doctorsprofile(name,type,speciality) VALUES ('Dr.Ranjani', 'Physician', 'Dermatology');
INSERT INTO doctorsprofile(name,type,speciality) VALUES ('Dr.Kannan', 'Surgeon', 'Cardiology');
INSERT INTO doctorsprofile(name,type,speciality) VALUES ('Dr.Karnan', 'Surgeon', 'Neurology');


INSERT INTO patientsrecord(name,gender,age,address,disease,admission,discharge) VALUES('JOHN', 'Male', '45', 'California', 'TUBERCULOSIS', '10/09/2019', '3/10/2019');

INSERT INTO appointment(name,age,gender,address,contact,doctor,disease,date,time) VALUES('Adam', '26', 'Male', 'Fremont,California', '+1203456732', 'Dr.Kannan', 'Body-Check up','20/10/2019', '10:00 AM');