CREATE TABLE patient (
                         patient_id UUID NOT NULL,
                         patient_name VARCHAR(255) NOT NULL,
                         patient_address VARCHAR(255) NOT NULL,
                         patient_email VARCHAR(255) NOT NULL UNIQUE,
                         patient_phone VARCHAR(255) NOT NULL,
                         patient_gender VARCHAR(255) NOT NULL,
                         patient_date_of_birthday DATE NOT NULL,
                         register_date DATE NOT NULL,
                         PRIMARY KEY (patient_id)
);


INSERT INTO patient (patient_id, patient_name, patient_address, patient_email, patient_phone, patient_gender, patient_date_of_birthday, register_date) VALUES
                                                                                                                                                           (RANDOM_UUID(), 'Aarav Sharma', '123 Park Street, Mumbai', 'aarav.sharma@example.com', '9876543210', 'Male', '1990-05-14', '2026-01-10'),
                                                                                                                                                           (RANDOM_UUID(), 'Aditi Rao', '456 MG Road, Bangalore', 'aditi.rao@example.com', '9812345678', 'Female', '1995-08-22', '2026-01-12'),
                                                                                                                                                           (RANDOM_UUID(), 'Arjun Patel', '789 Link Road, Ahmedabad', 'arjun.patel@example.com', '9922334455', 'Male', '1988-11-02', '2026-01-15'),
                                                                                                                                                           (RANDOM_UUID(), 'Diya Iyer', '12 Anna Salai, Chennai', 'diya.iyer@example.com', '9444012345', 'Female', '2000-12-05', '2026-01-20'),
                                                                                                                                                           (RANDOM_UUID(), 'Vivaan Das', '88 Salt Lake, Kolkata', 'vivaan.das@example.com', '9830098765', 'Male', '1985-03-30', '2026-01-22'),
                                                                                                                                                           (RANDOM_UUID(), 'Ananya Singh', '55 Cyber City, Gurgaon', 'ananya.singh@example.com', '9111223344', 'Female', '1993-07-19', '2026-02-01'),
                                                                                                                                                           (RANDOM_UUID(), 'Kabir Malhotra', '102 Banjara Hills, Hyderabad', 'kabir.m@example.com', '9246011223', 'Male', '1992-01-25', '2026-02-03'),
                                                                                                                                                           (RANDOM_UUID(), 'Meera Nair', '47 Marine Drive, Kochi', 'meera.nair@example.com', '9447055667', 'Female', '1978-09-14', '2026-02-05'),
                                                                                                                                                           (RANDOM_UUID(), 'Rohan Joshi', '216 FC Road, Pune', 'rohan.joshi@example.com', '9822011223', 'Male', '1996-04-11', '2026-02-10'),
                                                                                                                                                           (RANDOM_UUID(), 'Sanya Verma', '14 Gomti Nagar, Lucknow', 'sanya.v@example.com', '9415088990', 'Female', '2002-10-31', '2026-02-14'),
                                                                                                                                                           (RANDOM_UUID(), 'Reyansh Gupta', '333 Tonk Road, Jaipur', 'reyansh.g@example.com', '9414077665', 'Male', '1983-06-08', '2026-02-18'),
                                                                                                                                                           (RANDOM_UUID(), 'Isha Choudhury', '90 Zoo Road, Guwahati', 'isha.c@example.com', '9435011224', 'Female', '1997-02-27', '2026-02-20'),
                                                                                                                                                           (RANDOM_UUID(), 'Sai Kumar', '72 Vizag Beach Rd, Visakhapatnam', 'sai.kumar@example.com', '9848012345', 'Male', '1991-07-07', '2026-02-25'),
                                                                                                                                                           (RANDOM_UUID(), 'Prisha Mishra', '505 Boring Road, Patna', 'prisha.m@example.com', '9334055667', 'Female', '1994-05-18', '2026-03-01'),
                                                                                                                                                           (RANDOM_UUID(), 'Aaryan Kapoor', '19 Sector 17, Chandigarh', 'aaryan.k@example.com', '9814011223', 'Male', '1989-10-12', '2026-03-04'),
                                                                                                                                                           (RANDOM_UUID(), 'Kiara Bhat', '88 Residency Road, Srinagar', 'kiara.bhat@example.com', '9419055443', 'Female', '1999-03-21', '2026-03-08'),
                                                                                                                                                           (RANDOM_UUID(), 'Devansh Hegde', '14 Race Course Rd, Coimbatore', 'devansh.h@example.com', '9443011223', 'Male', '1987-12-30', '2026-03-12'),
                                                                                                                                                           (RANDOM_UUID(), 'Avani Kulkarni', '412 Hubli Bypass, Hubli', 'avani.k@example.com', '9448055667', 'Female', '1992-06-15', '2026-03-15'),
                                                                                                                                                           (RANDOM_UUID(), 'Krishna Reddy', '99 MG Road, Vijayawada', 'krishna.r@example.com', '9849011223', 'Male', '1980-04-04', '2026-03-19'),
                                                                                                                                                           (RANDOM_UUID(), 'Myra Fernandes', '56 Panaji Church Square, Goa', 'myra.f@example.com', '9823055667', 'Female', '1995-11-11', '2026-03-22');


SELECT * FROM patient;