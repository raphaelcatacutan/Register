-- TODO not exist


-- Create Dimension Tables
CREATE TABLE SCHOOLYEAR (
    syear VARCHAR(9) PRIMARY KEY -- Format: 2023-2024
);

CREATE TABLE SEMESTER (
    semester VARCHAR(1) PRIMARY KEY -- Values: 1, 2, 3, S
);

CREATE TABLE COLLEGE (
    college_code VARCHAR(10) PRIMARY KEY,
    description VARCHAR(200) NOT NULL,
    date_opened DATE NOT NULL,
    date_closed DATE DEFAULT TO_DATE('9999-12-31', 'YYYY-MM-DD'),
    status VARCHAR(1) DEFAULT 'A'
);

CREATE TABLE COURSE (
    course_code VARCHAR(20) PRIMARY KEY,
    description VARCHAR(200) NOT NULL,
    college_code VARCHAR(10) NOT NULL,
    date_opened DATE NOT NULL,
    date_closed DATE DEFAULT TO_DATE('9999-12-31', 'YYYY-MM-DD'),
    status VARCHAR(1) DEFAULT 'A',
    CONSTRAINT fk_course_college FOREIGN KEY (college_code) REFERENCES COLLEGE (college_code)
);

CREATE TABLE STUDENT (
    student_no VARCHAR(10) PRIMARY KEY,
    lastname VARCHAR(50) NOT NULL,
    firstname VARCHAR(50) NOT NULL,
    email VARCHAR(100),
    gender CHAR(1) CHECK (gender IN ('M', 'F')),
    course_code VARCHAR(20) NOT NULL,
    cp_num VARCHAR(15),
    address VARCHAR(200),
    bday DATE,
    status VARCHAR(1) DEFAULT 'A',
    date_started DATE NOT NULL,
    date_graduated DATE,
    CONSTRAINT fk_student_course FOREIGN KEY (course_code) REFERENCES COURSE (course_code)
);

CREATE TABLE EMPLOYEE (
    employee_id VARCHAR(10) PRIMARY KEY,
    lastname VARCHAR(50) NOT NULL,
    firstname VARCHAR(50) NOT NULL,
    email VARCHAR(100),
    gender CHAR(1) CHECK (gender IN ('M', 'F')),
    cp_num VARCHAR(15),
    address VARCHAR(200),
    bday DATE,
    status VARCHAR(1) DEFAULT 'A',
    date_started DATE NOT NULL,
    date_resigned DATE DEFAULT TO_DATE('9999-12-31', 'YYYY-MM-DD')
);

CREATE TABLE SUBJECT (
    subject_code VARCHAR(10) NOT NULL,
    description VARCHAR(200) NOT NULL,
    units INTEGER DEFAULT 3,
    curriculum VARCHAR(10) DEFAULT '2000',
    college_code VARCHAR(10) NOT NULL,
    status VARCHAR(1) DEFAULT 'A',
    date_opened DATE,
    date_closed DATE,
    CONSTRAINT fk_subject_college FOREIGN KEY (college_code) REFERENCES COLLEGE (college_code),
    CONSTRAINT pk_subject PRIMARY KEY (subject_code, college_code)
);

-- Create Fact Tables
CREATE TABLE SUBJECT_SCHEDULE (
    syear VARCHAR(9) NOT NULL,
    semester VARCHAR(1) NOT NULL,
    college_code VARCHAR(10) NOT NULL,
    block_no VARCHAR(15) NOT NULL,
    subject_code VARCHAR(10) NOT NULL,
    day VARCHAR(10) NOT NULL,
    time VARCHAR(20) NOT NULL,
    room VARCHAR(10) NOT NULL,
    type VARCHAR(10) NOT NULL,
    sequence_no INTEGER DEFAULT 1,
    employee_id VARCHAR(10) DEFAULT 'TBA',
    CONSTRAINT fk_schedule_syear FOREIGN KEY (syear) REFERENCES SCHOOLYEAR (syear),
    CONSTRAINT fk_schedule_semester FOREIGN KEY (semester) REFERENCES SEMESTER (semester),
    CONSTRAINT fk_schedule_college FOREIGN KEY (college_code) REFERENCES COLLEGE (college_code),
    CONSTRAINT fk_schedule_subject FOREIGN KEY (subject_code) REFERENCES SUBJECT (subject_code),
    CONSTRAINT fk_schedule_employee FOREIGN KEY (employee_id) REFERENCES EMPLOYEE (employee_id),
    CONSTRAINT pk_subject_schedule PRIMARY KEY (syear, semester, block_no, subject_code, sequence_no, college_code)
);

CREATE TABLE GRADES (
    syear VARCHAR(9) NOT NULL,
    semester VARCHAR(1) NOT NULL,
    student_no VARCHAR(10) NOT NULL,
    subject_code VARCHAR(10) NOT NULL,
    block_no VARCHAR(15) NOT NULL,
    grade DECIMAL(3, 2),
    CONSTRAINT fk_grades_syear FOREIGN KEY (syear) REFERENCES SCHOOLYEAR (syear),
    CONSTRAINT fk_grades_semester FOREIGN KEY (semester) REFERENCES SEMESTER (semester),
    CONSTRAINT fk_grades_student FOREIGN KEY (student_no) REFERENCES STUDENT (student_no),
    CONSTRAINT fk_grades_subject FOREIGN KEY (subject_code) REFERENCES SUBJECT (subject_code),
    CONSTRAINT pk_grades PRIMARY KEY (syear, semester, student_no, subject_code)
);
