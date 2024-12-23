INSERT INTO SCHOOLYEAR (syear) VALUES ('2023-2024');
INSERT INTO SCHOOLYEAR (syear) VALUES ('2024-2025');
INSERT INTO SCHOOLYEAR (syear) VALUES ('2025-2026');

-- Insert into SEMESTER
INSERT INTO SEMESTER (semester) VALUES ('1');
INSERT INTO SEMESTER (semester) VALUES ('2');
INSERT INTO SEMESTER (semester) VALUES ('S');


INSERT INTO COLLEGE (college_code, description, date_opened, date_closed, status)
VALUES ('ENG', 'College of Engineering', TO_DATE('2000-06-01', 'YYYY-MM-DD'), TO_DATE('9999-12-31', 'YYYY-MM-DD'), 'A');

INSERT INTO COLLEGE (college_code, description, date_opened, date_closed, status)
VALUES ('SCI', 'College of Science', TO_DATE('1998-08-15', 'YYYY-MM-DD'), TO_DATE('9999-12-31', 'YYYY-MM-DD'), 'A');

INSERT INTO COLLEGE (college_code, description, date_opened, date_closed, status)
VALUES ('BUS', 'College of Business Administration', TO_DATE('2005-09-01', 'YYYY-MM-DD'), TO_DATE('9999-12-31', 'YYYY-MM-DD'), 'A');

INSERT INTO COLLEGE (college_code, description, date_opened, date_closed, status)
VALUES ('ART', 'College of Arts and Humanities', TO_DATE('1995-06-10', 'YYYY-MM-DD'), TO_DATE('9999-12-31', 'YYYY-MM-DD'), 'A');

INSERT INTO COLLEGE (college_code, description, date_opened, date_closed, status)
VALUES ('MED', 'College of Medicine', TO_DATE('2010-01-05', 'YYYY-MM-DD'), TO_DATE('9999-12-31', 'YYYY-MM-DD'), 'A');


-- Courses
INSERT INTO COURSE (course_code, description, college_code, date_opened, date_closed, status, password)
VALUES ('BSCE', 'Bachelor of Science in Civil Engineering', 'ENG', TO_DATE('2000-06-01', 'YYYY-MM-DD'), TO_DATE('9999-12-31', 'YYYY-MM-DD'), 'A', NULL);

INSERT INTO COURSE (course_code, description, college_code, date_opened, date_closed, status, password)
VALUES ('BSEE', 'Bachelor of Science in Electrical Engineering', 'ENG', TO_DATE('2001-06-01', 'YYYY-MM-DD'), TO_DATE('9999-12-31', 'YYYY-MM-DD'), 'A', NULL);

INSERT INTO COURSE (course_code, description, college_code, date_opened, date_closed, status, password)
VALUES ('BSIT', 'Bachelor of Science in Information Technology', 'SCI', TO_DATE('2005-06-01', 'YYYY-MM-DD'), TO_DATE('9999-12-31', 'YYYY-MM-DD'), 'A', NULL);

INSERT INTO COURSE (course_code, description, college_code, date_opened, date_closed, status, password)
VALUES ('BSCS', 'Bachelor of Science in Computer Science', 'SCI', TO_DATE('2003-06-01', 'YYYY-MM-DD'), TO_DATE('9999-12-31', 'YYYY-MM-DD'), 'A', NULL);

INSERT INTO COURSE (course_code, description, college_code, date_opened, date_closed, status, password)
VALUES ('BSBA', 'Bachelor of Science in Business Administration', 'BUS', TO_DATE('2008-06-01', 'YYYY-MM-DD'), TO_DATE('9999-12-31', 'YYYY-MM-DD'), 'A', NULL);

INSERT INTO COURSE (course_code, description, college_code, date_opened, date_closed, status, password)
VALUES ('BSA', 'Bachelor of Science in Accountancy', 'BUS', TO_DATE('2009-06-01', 'YYYY-MM-DD'), TO_DATE('9999-12-31', 'YYYY-MM-DD'), 'A', NULL);

INSERT INTO COURSE (course_code, description, college_code, date_opened, date_closed, status, password)
VALUES ('BAEL', 'Bachelor of Arts in English Language', 'ART', TO_DATE('1998-06-01', 'YYYY-MM-DD'), TO_DATE('9999-12-31', 'YYYY-MM-DD'), 'A', NULL);

INSERT INTO COURSE (course_code, description, college_code, date_opened, date_closed, status, password)
VALUES ('BSIS', 'Bachelor of Science in Information Systems', 'SCI', TO_DATE('2006-06-01', 'YYYY-MM-DD'), TO_DATE('9999-12-31', 'YYYY-MM-DD'), 'A', NULL);

INSERT INTO COURSE (course_code, description, college_code, date_opened, date_closed, status, password)
VALUES ('MD', 'Doctor of Medicine', 'MED', TO_DATE('2010-06-01', 'YYYY-MM-DD'), TO_DATE('9999-12-31', 'YYYY-MM-DD'), 'A', NULL);

INSERT INTO COURSE (course_code, description, college_code, date_opened, date_closed, status, password)
VALUES ('BSPSY', 'Bachelor of Science in Psychology', 'ART', TO_DATE('2004-06-01', 'YYYY-MM-DD'), TO_DATE('9999-12-31', 'YYYY-MM-DD'), 'A', NULL);

-- Students
-- Engineering Students (BSCE, BSEE)
INSERT INTO STUDENT VALUES (10001, 'Smith', 'John', 'john.smith@example.com', 'M', 'BSCE', 9123456789, '123 Elm Street', TO_DATE('2002-05-15', 'YYYY-MM-DD'), 'A', TO_DATE('2020-06-01', 'YYYY-MM-DD'), NULL);
INSERT INTO STUDENT VALUES (10002, 'Doe', 'Jane', 'jane.doe@example.com', 'F', 'BSEE', 9123456788, '456 Pine Avenue', TO_DATE('2003-08-22', 'YYYY-MM-DD'), 'A', TO_DATE('2020-06-01', 'YYYY-MM-DD'), NULL);
INSERT INTO STUDENT VALUES (10003, 'Brown', 'James', 'james.brown@example.com', 'M', 'BSCE', 9123456787, '789 Oak Lane', TO_DATE('2002-11-02', 'YYYY-MM-DD'), 'A', TO_DATE('2021-06-01', 'YYYY-MM-DD'), NULL);
INSERT INTO STUDENT VALUES (10004, 'Taylor', 'Emily', 'emily.taylor@example.com', 'F', 'BSEE', 9123456786, '101 Maple Circle', TO_DATE('2002-01-18', 'YYYY-MM-DD'), 'A', TO_DATE('2021-06-01', 'YYYY-MM-DD'), NULL);
INSERT INTO STUDENT VALUES (10005, 'Williams', 'Daniel', 'daniel.williams@example.com', 'M', 'BSCE', 9123456785, '202 Birch Blvd', TO_DATE('2003-03-25', 'YYYY-MM-DD'), 'A', TO_DATE('2019-06-01', 'YYYY-MM-DD'), NULL);
INSERT INTO STUDENT VALUES (10006, 'Clark', 'Sophia', 'sophia.clark@example.com', 'F', 'BSEE', 9123456784, '303 Cedar Avenue', TO_DATE('2004-07-12', 'YYYY-MM-DD'), 'A', TO_DATE('2019-06-01', 'YYYY-MM-DD'), NULL);

-- Science Students (BSCS, BSIT)
INSERT INTO STUDENT VALUES (10007, 'Martin', 'William', 'william.martin@example.com', 'M', 'BSCS', 9123456783, '404 Willow Street', TO_DATE('2001-10-30', 'YYYY-MM-DD'), 'A', TO_DATE('2020-06-01', 'YYYY-MM-DD'), NULL);
INSERT INTO STUDENT VALUES (10008, 'Lee', 'Sophia', 'sophia.lee@example.com', 'F', 'BSIT', 9123456782, '505 Chestnut Drive', TO_DATE('2003-12-14', 'YYYY-MM-DD'), 'A', TO_DATE('2020-06-01', 'YYYY-MM-DD'), NULL);
INSERT INTO STUDENT VALUES (10009, 'Garcia', 'Ethan', 'ethan.garcia@example.com', 'M', 'BSCS', 9123456781, '606 Sycamore Road', TO_DATE('2002-09-19', 'YYYY-MM-DD'), 'A', TO_DATE('2018-06-01', 'YYYY-MM-DD'), NULL);
INSERT INTO STUDENT VALUES (10010, 'Martinez', 'Olivia', 'olivia.martinez@example.com', 'F', 'BSIT', 9123456780, '707 Poplar Lane', TO_DATE('2003-05-11', 'YYYY-MM-DD'), 'A', TO_DATE('2018-06-01', 'YYYY-MM-DD'), NULL);
INSERT INTO STUDENT VALUES (10011, 'Wilson', 'Jacob', 'jacob.wilson@example.com', 'M', 'BSCS', 9123456779, '808 Walnut Way', TO_DATE('2004-06-30', 'YYYY-MM-DD'), 'A', TO_DATE('2017-06-01', 'YYYY-MM-DD'), NULL);
INSERT INTO STUDENT VALUES (10012, 'Harris', 'Ella', 'ella.harris@example.com', 'F', 'BSIT', 9123456778, '909 Aspen Street', TO_DATE('2003-02-16', 'YYYY-MM-DD'), 'A', TO_DATE('2019-06-01', 'YYYY-MM-DD'), NULL);

-- Business Students (BSBA, BSA)
INSERT INTO STUDENT VALUES (10013, 'Davis', 'Alexander', 'alexander.davis@example.com', 'M', 'BSBA', 9123456777, '123 Elm Circle', TO_DATE('2002-05-21', 'YYYY-MM-DD'), 'A', TO_DATE('2018-06-01', 'YYYY-MM-DD'), NULL);
INSERT INTO STUDENT VALUES (10014, 'Miller', 'Isabella', 'isabella.miller@example.com', 'F', 'BSA', 9123456776, '456 Oak Avenue', TO_DATE('2004-08-05', 'YYYY-MM-DD'), 'A', TO_DATE('2018-06-01', 'YYYY-MM-DD'), NULL);
INSERT INTO STUDENT VALUES (10015, 'Moore', 'Benjamin', 'benjamin.moore@example.com', 'M', 'BSBA', 9123456775, '789 Pine Blvd', TO_DATE('2003-03-18', 'YYYY-MM-DD'), 'A', TO_DATE('2017-06-01', 'YYYY-MM-DD'), NULL);
INSERT INTO STUDENT VALUES (10016, 'Anderson', 'Mia', 'mia.anderson@example.com', 'F', 'BSA', 9123456774, '202 Maple Lane', TO_DATE('2004-12-10', 'YYYY-MM-DD'), 'A', TO_DATE('2017-06-01', 'YYYY-MM-DD'), NULL);

-- Arts and Medicine Students (BAEL, MD)
INSERT INTO STUDENT VALUES (10017, 'King', 'Matthew', 'matthew.king@example.com', 'M', 'BAEL', 9123456773, '101 Birch Blvd', TO_DATE('2002-11-12', 'YYYY-MM-DD'), 'A', TO_DATE('2020-06-01', 'YYYY-MM-DD'), NULL);
INSERT INTO STUDENT VALUES (10018, 'Perez', 'Amelia', 'amelia.perez@example.com', 'F', 'MD', 9123456772, '303 Oak Avenue', TO_DATE('2003-04-20', 'YYYY-MM-DD'), 'A', TO_DATE('2020-06-01', 'YYYY-MM-DD'), NULL);
INSERT INTO STUDENT VALUES (10019, 'White', 'David', 'david.white@example.com', 'M', 'BAEL', 9123456771, '404 Cedar Street', TO_DATE('2004-07-11', 'YYYY-MM-DD'), 'A', TO_DATE('2019-06-01', 'YYYY-MM-DD'), NULL);
INSERT INTO STUDENT VALUES (10020, 'Hall', 'Charlotte', 'charlotte.hall@example.com', 'F', 'MD', 9123456770, '505 Walnut Drive', TO_DATE('2003-09-05', 'YYYY-MM-DD'), 'A', TO_DATE('2019-06-01', 'YYYY-MM-DD'), NULL);

-- Additional Students
INSERT INTO STUDENT VALUES (10021, 'Allen', 'Lucas', 'lucas.allen@example.com', 'M', 'BSCE', 9123456769, '606 Birch Circle', TO_DATE('2002-10-28', 'YYYY-MM-DD'), 'A', TO_DATE('2019-06-01', 'YYYY-MM-DD'), NULL);
INSERT INTO STUDENT VALUES (10022, 'Young', 'Emma', 'emma.young@example.com', 'F', 'BSIT', 9123456768, '707 Cedar Avenue', TO_DATE('2003-06-13', 'YYYY-MM-DD'), 'A', TO_DATE('2019-06-01', 'YYYY-MM-DD'), NULL);
INSERT INTO STUDENT VALUES (10023, 'Hernandez', 'Liam', 'liam.hernandez@example.com', 'M', 'BSEE', 9123456767, '808 Oak Lane', TO_DATE('2004-08-19', 'YYYY-MM-DD'), 'A', TO_DATE('2021-06-01', 'YYYY-MM-DD'), NULL);
INSERT INTO STUDENT VALUES (10024, 'Lopez', 'Sophia', 'sophia.lopez@example.com', 'F', 'MD', 9123456766, '909 Maple Blvd', TO_DATE('2004-01-22', 'YYYY-MM-DD'), 'A', TO_DATE('2021-06-01', 'YYYY-MM-DD'), NULL);
INSERT INTO STUDENT VALUES (10025, 'Gonzalez', 'James', 'james.gonzalez@example.com', 'M', 'BSCS', 9123456765, '101 Pine Street', TO_DATE('2003-10-16', 'YYYY-MM-DD'), 'A', TO_DATE('2020-06-01', 'YYYY-MM-DD'), NULL);


-- Employees
INSERT INTO EMPLOYEE VALUES ('E001', 'Johnson', 'Michael', 'michael.johnson@example.com', 'M', '9123456789', '123 Elm Street', TO_DATE('1980-06-15', 'YYYY-MM-DD'), 'A', TO_DATE('2010-01-01', 'YYYY-MM-DD'), NULL);
INSERT INTO EMPLOYEE VALUES ('E002', 'Williams', 'Sarah', 'sarah.williams@example.com', 'F', '9123456788', '456 Oak Avenue', TO_DATE('1985-11-03', 'YYYY-MM-DD'), 'A', TO_DATE('2012-05-15', 'YYYY-MM-DD'), NULL);

-- Science Faculty
INSERT INTO EMPLOYEE VALUES ('E003', 'Brown', 'Robert', 'robert.brown@example.com', 'M', '9123456787', '789 Pine Blvd', TO_DATE('1978-03-21', 'YYYY-MM-DD'), 'A', TO_DATE('2008-07-01', 'YYYY-MM-DD'), NULL);
INSERT INTO EMPLOYEE VALUES ('E004', 'Jones', 'Emma', 'emma.jones@example.com', 'F', '9123456786', '101 Maple Circle', TO_DATE('1990-09-12', 'YYYY-MM-DD'), 'A', TO_DATE('2015-03-20', 'YYYY-MM-DD'), NULL);

-- Business Faculty
INSERT INTO EMPLOYEE VALUES ('E005', 'Garcia', 'David', 'david.garcia@example.com', 'M', '9123456785', '202 Birch Blvd', TO_DATE('1982-02-28', 'YYYY-MM-DD'), 'A', TO_DATE('2011-11-10', 'YYYY-MM-DD'), NULL);
INSERT INTO EMPLOYEE VALUES ('E006', 'Martinez', 'Sophia', 'sophia.martinez@example.com', 'F', '9123456784', '303 Cedar Avenue', TO_DATE('1987-04-17', 'YYYY-MM-DD'), 'A', TO_DATE('2013-09-05', 'YYYY-MM-DD'), NULL);

-- Arts Faculty
INSERT INTO EMPLOYEE VALUES ('E007', 'Clark', 'James', 'james.clark@example.com', 'M', '9123456783', '404 Walnut Way', TO_DATE('1975-01-30', 'YYYY-MM-DD'), 'A', TO_DATE('2005-02-14', 'YYYY-MM-DD'), NULL);
INSERT INTO EMPLOYEE VALUES ('E008', 'Lewis', 'Emily', 'emily.lewis@example.com', 'F', '9123456782', '505 Aspen Street', TO_DATE('1989-10-09', 'YYYY-MM-DD'), 'A', TO_DATE('2016-08-12', 'YYYY-MM-DD'), NULL);

-- Medicine Faculty
INSERT INTO EMPLOYEE VALUES ('E009', 'Walker', 'Ethan', 'ethan.walker@example.com', 'M', '9123456781', '606 Sycamore Road', TO_DATE('1983-12-23', 'YYYY-MM-DD'), 'A', TO_DATE('2014-06-30', 'YYYY-MM-DD'), NULL);
INSERT INTO EMPLOYEE VALUES ('E010', 'Young', 'Olivia', 'olivia.young@example.com', 'F', '9123456780', '707 Poplar Lane', TO_DATE('1992-07-05', 'YYYY-MM-DD'), 'A', TO_DATE('2018-01-01', 'YYYY-MM-DD'), NULL);


-- Engineering Subjects
INSERT INTO SUBJECT VALUES ('ENG101', 'Introduction to Engineering', 3, '2023', 'ENG', 'A', TO_DATE('2023-01-01', 'YYYY-MM-DD'), NULL);
INSERT INTO SUBJECT VALUES ('ENG102', 'Engineering Mathematics', 3, '2023', 'ENG', 'A', TO_DATE('2023-01-01', 'YYYY-MM-DD'), NULL);

-- Science Subjects
INSERT INTO SUBJECT VALUES ('SCI101', 'Introduction to Computer Science', 3, '2023', 'SCI', 'A', TO_DATE('2023-01-01', 'YYYY-MM-DD'), NULL);
INSERT INTO SUBJECT VALUES ('SCI102', 'Data Structures', 3, '2023', 'SCI', 'A', TO_DATE('2023-01-01', 'YYYY-MM-DD'), NULL);

-- Business Subjects
INSERT INTO SUBJECT VALUES ('BUS101', 'Principles of Management', 3, '2023', 'BUS', 'A', TO_DATE('2023-01-01', 'YYYY-MM-DD'), NULL);
INSERT INTO SUBJECT VALUES ('BUS102', 'Financial Accounting', 3, '2023', 'BUS', 'A', TO_DATE('2023-01-01', 'YYYY-MM-DD'), NULL);

-- Arts Subjects
INSERT INTO SUBJECT VALUES ('ART101', 'Introduction to Fine Arts', 3, '2023', 'ART', 'A', TO_DATE('2023-01-01', 'YYYY-MM-DD'), NULL);
INSERT INTO SUBJECT VALUES ('ART102', 'Creative Writing', 3, '2023', 'ART', 'A', TO_DATE('2023-01-01', 'YYYY-MM-DD'), NULL);

-- Medicine Subjects
INSERT INTO SUBJECT VALUES ('MED101', 'Anatomy and Physiology', 4, '2023', 'MED', 'A', TO_DATE('2023-01-01', 'YYYY-MM-DD'), NULL);
INSERT INTO SUBJECT VALUES ('MED102', 'Biochemistry', 4, '2023', 'MED', 'A', TO_DATE('2023-01-01', 'YYYY-MM-DD'), NULL);


-- Grades
-- Engineering Student Grades
INSERT INTO GRADES (syear, semester, student_no, subject_code, block_no, grade) 
VALUES ('2023-2024', '1', 10001, 'ENG101', 'A1', 1.25);
INSERT INTO GRADES (syear, semester, student_no, subject_code, block_no, grade) 
VALUES ('2023-2024', '1', 10002, 'ENG101', 'A2', 1.00);
INSERT INTO GRADES (syear, semester, student_no, subject_code, block_no, grade) 
VALUES ('2023-2024', '1', 10008, 'ENG101', 'A3', 1.50);
INSERT INTO GRADES (syear, semester, student_no, subject_code, block_no, grade) 
VALUES ('2023-2024', '1', 10009, 'ENG101', 'A4', 1.75);

-- Science Student Grades
INSERT INTO GRADES (syear, semester, student_no, subject_code, block_no, grade) 
VALUES ('2023-2024', '1', 10003, 'SCI101', 'B1', 1.50);
INSERT INTO GRADES (syear, semester, student_no, subject_code, block_no, grade) 
VALUES ('2023-2024', '1', 10004, 'SCI101', 'B2', 1.25);
INSERT INTO GRADES (syear, semester, student_no, subject_code, block_no, grade) 
VALUES ('2023-2024', '1', 10010, 'SCI101', 'B3', 1.00);
INSERT INTO GRADES (syear, semester, student_no, subject_code, block_no, grade) 
VALUES ('2023-2024', '1', 10011, 'SCI101', 'B4', 1.25);

-- Business Student Grades
INSERT INTO GRADES (syear, semester, student_no, subject_code, block_no, grade) 
VALUES ('2023-2024', '1', 10005, 'BUS101', 'C1', 1.75);
INSERT INTO GRADES (syear, semester, student_no, subject_code, block_no, grade) 
VALUES ('2023-2024', '1', 10006, 'BUS101', 'C2', 1.00);
INSERT INTO GRADES (syear, semester, student_no, subject_code, block_no, grade) 
VALUES ('2023-2024', '1', 10012, 'BUS101', 'C3', 1.50);
INSERT INTO GRADES (syear, semester, student_no, subject_code, block_no, grade) 
VALUES ('2023-2024', '1', 10013, 'BUS101', 'C4', 1.75);

-- Arts Student Grades
INSERT INTO GRADES (syear, semester, student_no, subject_code, block_no, grade) 
VALUES ('2023-2024', '1', 10007, 'ART101', 'D1', 1.25);
INSERT INTO GRADES (syear, semester, student_no, subject_code, block_no, grade) 
VALUES ('2023-2024', '1', 10008, 'ART101', 'D2', 1.50);
INSERT INTO GRADES (syear, semester, student_no, subject_code, block_no, grade) 
VALUES ('2023-2024', '1', 10014, 'ART101', 'D2', 1.00);
INSERT INTO GRADES (syear, semester, student_no, subject_code, block_no, grade) 
VALUES ('2023-2024', '1', 10015, 'ART101', 'D3', 1.50);

-- Medicine Student Grades
INSERT INTO GRADES (syear, semester, student_no, subject_code, block_no, grade) 
VALUES ('2023-2024', '1', 10009, 'MED101', 'E1', 1.00);
INSERT INTO GRADES (syear, semester, student_no, subject_code, block_no, grade) 
VALUES ('2023-2024', '1', 10010, 'MED101', 'E2', 1.25);
INSERT INTO GRADES (syear, semester, student_no, subject_code, block_no, grade) 
VALUES ('2023-2024', '1', 10016, 'MED101', 'E1', 1.75);
INSERT INTO GRADES (syear, semester, student_no, subject_code, block_no, grade) 
VALUES ('2023-2024', '1', 10017, 'MED101', 'E2', 1.25);

-- SCHEDULE
-- Sample data for SCHEDULE

-- Schedule 1
INSERT INTO SCHEDULE (syear, semester, college_code, block_no, subject_code, day, time, room, type, sequence_no, employee_id)
VALUES ('2023-2024', '1', 'ENG', 'A1', 'ENG101', 'Monday', '08:00-10:00', 'Room 101', 'Lecture', 1, 'E001');

-- Schedule 2
INSERT INTO SCHEDULE (syear, semester, college_code, block_no, subject_code, day, time, room, type, sequence_no, employee_id)
VALUES ('2023-2024', '1', 'ENG', 'A2', 'ENG102', 'Tuesday', '10:00-12:00', 'Room 102', 'Lecture', 1, 'E002');

-- Schedule 3
INSERT INTO SCHEDULE (syear, semester, college_code, block_no, subject_code, day, time, room, type, sequence_no, employee_id)
VALUES ('2023-2024', '1', 'SCI', 'B1', 'SCI101', 'Wednesday', '08:00-10:00', 'Room 201', 'Lecture', 1, 'E003');

-- Schedule 4
INSERT INTO SCHEDULE (syear, semester, college_code, block_no, subject_code, day, time, room, type, sequence_no, employee_id)
VALUES ('2023-2024', '2', 'ENG', 'A1', 'ENG101', 'Monday', '13:00-15:00', 'Room 103', 'Lecture', 2, 'E004');

-- Schedule 5
INSERT INTO SCHEDULE (syear, semester, college_code, block_no, subject_code, day, time, room, type, sequence_no, employee_id)
VALUES ('2023-2024', '2', 'SCI', 'B2', 'SCI102', 'Thursday', '09:00-11:00', 'Room 202', 'Lecture', 1, 'E005');

-- Schedule 6
INSERT INTO SCHEDULE (syear, semester, college_code, block_no, subject_code, day, time, room, type, sequence_no, employee_id)
VALUES ('2023-2024', '1', 'BUS', 'C1', 'ART101', 'Monday', '10:00-12:00', 'Room 301', 'Lecture', 1, 'E006');

-- Schedule 7
INSERT INTO SCHEDULE (syear, semester, college_code, block_no, subject_code, day, time, room, type, sequence_no, employee_id)
VALUES ('2023-2024', '2', 'BUS', 'D1', 'ART102', 'Friday', '11:00-13:00', 'Room 401', 'Lecture', 1, 'E007');

-- Schedule 8
INSERT INTO SCHEDULE (syear, semester, college_code, block_no, subject_code, day, time, room, type, sequence_no, employee_id)
VALUES ('2023-2024', '1', 'ENG', 'C2', 'ENG102', 'Tuesday', '14:00-16:00', 'Room 302', 'Lecture', 2, 'E008');

-- Schedule 9
INSERT INTO SCHEDULE (syear, semester, college_code, block_no, subject_code, day, time, room, type, sequence_no, employee_id)
VALUES ('2023-2024', '2', 'BUS', 'D2', 'BUS102', 'Wednesday', '12:00-14:00', 'Room 402', 'Lecture', 1, 'E009');

-- Schedule 10
INSERT INTO SCHEDULE (syear, semester, college_code, block_no, subject_code, day, time, room, type, sequence_no, employee_id)
VALUES ('2023-2024', '1', 'ENG', 'A1', 'ENG102', 'Friday', '09:00-11:00', 'Room 103', 'Lecture', 1, 'E010');

-- Schedule 11
INSERT INTO SCHEDULE (syear, semester, college_code, block_no, subject_code, day, time, room, type, sequence_no, employee_id)
VALUES ('2023-2024', '1', 'ENG', 'A1', 'ENG101', 'Wednesday', '08:00-10:00', 'Room 101', 'Lecture', 2, 'E011');

-- Schedule 12
INSERT INTO SCHEDULE (syear, semester, college_code, block_no, subject_code, day, time, room, type, sequence_no, employee_id)
VALUES ('2023-2024', '1', 'ENG', 'A2', 'ENG102', 'Thursday', '10:00-12:00', 'Room 102', 'Lecture', 2, 'E012');

-- Schedule 13
INSERT INTO SCHEDULE (syear, semester, college_code, block_no, subject_code, day, time, room, type, sequence_no, employee_id)
VALUES ('2023-2024', '1', 'SCI', 'B1', 'SCI101', 'Monday', '08:00-10:00', 'Room 201', 'Lecture', 2, 'E013');

-- Schedule 14
INSERT INTO SCHEDULE (syear, semester, college_code, block_no, subject_code, day, time, room, type, sequence_no, employee_id)
VALUES ('2023-2024', '1', 'SCI', 'B2', 'SCI102', 'Wednesday', '10:00-12:00', 'Room 202', 'Lecture', 2, 'E014');

-- Schedule 15
INSERT INTO SCHEDULE (syear, semester, college_code, block_no, subject_code, day, time, room, type, sequence_no, employee_id)
VALUES ('2023-2024', '2', 'ENG', 'A1', 'ENG101', 'Tuesday', '13:00-15:00', 'Room 103', 'Lecture', 3, 'E015');

-- Schedule 16
INSERT INTO SCHEDULE (syear, semester, college_code, block_no, subject_code, day, time, room, type, sequence_no, employee_id)
VALUES ('2023-2024', '2', 'ENG', 'A2', 'ENG102', 'Thursday', '14:00-16:00', 'Room 102', 'Lecture', 3, 'E016');

-- Schedule 17
INSERT INTO SCHEDULE (syear, semester, college_code, block_no, subject_code, day, time, room, type, sequence_no, employee_id)
VALUES ('2023-2024', '2', 'SCI', 'B1', 'SCI101', 'Monday', '13:00-15:00', 'Room 201', 'Lecture', 3, 'E017');

-- Schedule 18
INSERT INTO SCHEDULE (syear, semester, college_code, block_no, subject_code, day, time, room, type, sequence_no, employee_id)
VALUES ('2023-2024', '2', 'SCI', 'B2', 'SCI102', 'Friday', '08:00-10:00', 'Room 202', 'Lecture', 3, 'E018');

-- Schedule 19
INSERT INTO SCHEDULE (syear, semester, college_code, block_no, subject_code, day, time, room, type, sequence_no, employee_id)
VALUES ('2023-2024', '1', 'BUS', 'C1', 'ART101', 'Wednesday', '09:00-11:00', 'Room 301', 'Lecture', 2, 'E019');

-- Schedule 20
INSERT INTO SCHEDULE (syear, semester, college_code, block_no, subject_code, day, time, room, type, sequence_no, employee_id)
VALUES ('2023-2024', '1', 'BUS', 'C2', 'ART102', 'Thursday', '11:00-13:00', 'Room 401', 'Lecture', 2, 'E020');

-- Schedule 21
INSERT INTO SCHEDULE (syear, semester, college_code, block_no, subject_code, day, time, room, type, sequence_no, employee_id)
VALUES ('2023-2024', '2', 'BUS', 'D1', 'ART101', 'Friday', '08:00-10:00', 'Room 301', 'Lecture', 2, 'E021');

-- Schedule 22
INSERT INTO SCHEDULE (syear, semester, college_code, block_no, subject_code, day, time, room, type, sequence_no, employee_id)
VALUES ('2023-2024', '2', 'BUS', 'D2', 'ART102', 'Monday', '10:00-12:00', 'Room 401', 'Lecture', 2, 'E022');

-- Schedule 23
INSERT INTO SCHEDULE (syear, semester, college_code, block_no, subject_code, day, time, room, type, sequence_no, employee_id)
VALUES ('2023-2024', '1', 'ENG', 'A1', 'ENG101', 'Thursday', '08:00-10:00', 'Room 101', 'Lecture', 3, 'E023');

-- Schedule 24
INSERT INTO SCHEDULE (syear, semester, college_code, block_no, subject_code, day, time, room, type, sequence_no, employee_id)
VALUES ('2023-2024', '1', 'ENG', 'A2', 'ENG102', 'Wednesday', '10:00-12:00', 'Room 102', 'Lecture', 3, 'E024');

-- Schedule 25
INSERT INTO SCHEDULE (syear, semester, college_code, block_no, subject_code, day, time, room, type, sequence_no, employee_id)
VALUES ('2023-2024', '2', 'ENG', 'A1', 'ENG101', 'Friday', '10:00-12:00', 'Room 103', 'Lecture', 4, 'E025');

-- Schedule 26
INSERT INTO SCHEDULE (syear, semester, college_code, block_no, subject_code, day, time, room, type, sequence_no, employee_id)
VALUES ('2023-2024', '2', 'ENG', 'A2', 'ENG102', 'Monday', '08:00-10:00', 'Room 102', 'Lecture', 4, 'E026');

-- Schedule 27
INSERT INTO SCHEDULE (syear, semester, college_code, block_no, subject_code, day, time, room, type, sequence_no, employee_id)
VALUES ('2023-2024', '1', 'SCI', 'B1', 'SCI101', 'Friday', '10:00-12:00', 'Room 201', 'Lecture', 3, 'E027');

-- Schedule 28
INSERT INTO SCHEDULE (syear, semester, college_code, block_no, subject_code, day, time, room, type, sequence_no, employee_id)
VALUES ('2023-2024', '1', 'SCI', 'B2', 'SCI102', 'Tuesday', '12:00-14:00', 'Room 202', 'Lecture', 3, 'E028');

-- Schedule 29
INSERT INTO SCHEDULE (syear, semester, college_code, block_no, subject_code, day, time, room, type, sequence_no, employee_id)
VALUES ('2023-2024', '2', 'BUS', 'C1', 'ART101', 'Thursday', '14:00-16:00', 'Room 301', 'Lecture', 3, 'E029');

-- Schedule 30
INSERT INTO SCHEDULE (syear, semester, college_code, block_no, subject_code, day, time, room, type, sequence_no, employee_id)
VALUES ('2023-2024', '2', 'BUS', 'C2', 'ART102', 'Tuesday', '08:00-10:00', 'Room 401', 'Lecture', 3, 'E030');

-- Schedule 31
INSERT INTO SCHEDULE (syear, semester, college_code, block_no, subject_code, day, time, room, type, sequence_no, employee_id)
VALUES ('2023-2024', '1', 'BUS', 'C1', 'ART101', 'Friday', '12:00-14:00', 'Room 301', 'Lecture', 3, 'E031');

-- Schedule 32
INSERT INTO SCHEDULE (syear, semester, college_code, block_no, subject_code, day, time, room, type, sequence_no, employee_id)
VALUES ('2023-2024', '1', 'BUS', 'C2', 'ART102', 'Wednesday', '14:00-16:00', 'Room 401', 'Lecture', 3, 'E032');