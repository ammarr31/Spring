CREATE TABLE Hospital(
	id NUMBER PRIMARY KEY,
	name VARCHAR2(100),
	numberOfDoctors NUMBER,
	numberOfPatient NUMBER
);

CREATE TABLE Doctor(
	id NUMBER PRIMARY KEY,
	userName VARCHAR2(100),
	salary NUMBER,
	hospital_id NUMBER NOT NULL,
	CONSTRAINT fkk_hoss_id FOREIGN KEY (hospital_id) REFERENCES Hospital(id)
);

CREATE TABLE DoctorDetails(
	id NUMBER PRIMARY KEY,
	fullAddress VARCHAR2(100),
	firstName VARCHAR2(100),
	lastName VARCHAR2(100),
	age NUMBER,
	doctor_id NUMBER CONSTRAINT docc_notnull NOT NULL,
	CONSTRAINT fkk_doc_id FOREIGN KEY (doctor_id) REFERENCES Doctor(id),
	UNIQUE(doctor_id)
);

CREATE TABLE Patient(
	id NUMBER PRIMARY KEY,
	name VARCHAR2(100),
	typeOfDisease VARCHAR2(100),
	doctor_id NUMBER NOT NULL,
	CONSTRAINT fkkk_doc_id FOREIGN KEY (doctor_id) REFERENCES Doctor(id)
);

CREATE TABLE Hospital_Patient(
	patient_id NUMBER NOT NULL,
	hospital_id NUMBER NOT NULL,
	CONSTRAINT fkkk_patient_id FOREIGN KEY (patient_id) REFERENCES Patient(id),
	CONSTRAINT fkkk_hospital_id FOREIGN KEY (hospital_id) REFERENCES Hospital(id)
);

