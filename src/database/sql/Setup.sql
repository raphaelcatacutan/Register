-- Drop tables if they already exist
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE GRADES CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN
      NULL; -- Ignore error if table does not exist
END;
/

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE SUBJECT_SCHEDULE CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN
      NULL; -- Ignore error if table does not exist
END;
/

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE SUBJECT CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN
      NULL; -- Ignore error if table does not exist
END;
/

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE EMPLOYEE CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN
      NULL; -- Ignore error if table does not exist
END;
/

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE STUDENT CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN
      NULL; -- Ignore error if table does not exist
END;
/

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE COURSE CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN
      NULL; -- Ignore error if table does not exist
END;
/

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE COLLEGE CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN
      NULL; -- Ignore error if table does not exist
END;
/

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE SEMESTER CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN
      NULL; -- Ignore error if table does not exist
END;
/

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE SCHOOLYEAR CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN
      NULL; -- Ignore error if table does not exist
END;
/

-- Create Dimension Tables
CREATE TABLE SCHOOLYEAR (
    syear          VARCHAR(9) PRIMARY KEY -- Format: 2023-2024
);

CREATE TABLE SEMESTER (
    semester       VARCHAR(1) PRIMARY KEY -- Values: 1, 2, 3, S
);

CREATE TABLE COLLEGE (
    college_code   VARCHAR(10) PRIMARY KEY,
    description    VARCHAR(200) NOT NULL,
    date_opened    DATE NOT NULL,
    date_closed    DATE DEFAULT TO_DATE('9999-12-31', 'YYYY-MM-DD'),
    status         VARCHAR(1) DEFAULT 'A'
);

CREATE TABLE COURSE (
    course_code    VARCHAR(20) PRIMARY KEY,
    description    VARCHAR(200) NOT NULL,
    college_code   VARCHAR(10) NOT NULL,
    date_opened    DATE NOT NULL,
    date_closed    DATE DEFAULT TO_DATE('9999-12-31', 'YYYY-MM-DD'),
    status         VARCHAR(1) DEFAULT 'A',
    password       VARCHAR(255),
    CONSTRAINT fk_course_college FOREIGN KEY (college_code) REFERENCES COLLEGE (college_code)
);

CREATE TABLE STUDENT (
    student_no     INTEGER PRIMARY KEY,
    lastname       VARCHAR(50),
    firstname      VARCHAR(50),
    email          VARCHAR(50) UNIQUE,
    gender         VARCHAR(1),
    course_code    VARCHAR(10) NOT NULL,
    cp_num         INTEGER,
    address        VARCHAR(100),
    bday           DATE,
    status         VARCHAR(1) DEFAULT 'A',
    date_started   DATE,
    date_graduated DATE,
    CONSTRAINT course_code_fk1 FOREIGN KEY (course_code) REFERENCES COURSE(course_code)
);

CREATE TABLE EMPLOYEE (
    employee_id    VARCHAR(10) PRIMARY KEY,
    lastname       VARCHAR(50) NOT NULL,
    firstname      VARCHAR(50) NOT NULL,
    email          VARCHAR(100),
    gender         CHAR(1) CHECK (gender IN ('M', 'F')),
    cp_num         VARCHAR(15),
    address        VARCHAR(200),
    bday           DATE,
    status         VARCHAR(1) DEFAULT 'A',
    date_started   DATE NOT NULL,
    date_resigned  DATE DEFAULT TO_DATE('9999-12-31', 'YYYY-MM-DD')
);

CREATE TABLE SUBJECT (
    subject_code    VARCHAR(10) PRIMARY KEY
    , description   VARCHAR(200) NOT NULL
    , units         INTEGER DEFAULT 3
    , curriculum    VARCHAR(10) DEFAULT '2000'
    , college_code  VARCHAR(10) NOT NULL
    , status        VARCHAR(1) DEFAULT 'A'
    , date_opened   DATE
    , date_closed   DATE
    , CONSTRAINT fk_subject_college FOREIGN KEY (college_code) REFERENCES COLLEGE (college_code)
);

CREATE TABLE SUBJECT_SCHEDULE (
    schedule_id             NUMBER PRIMARY KEY
    , syear                 VARCHAR(9) NOT NULL
    , semester              VARCHAR(1) NOT NULL
    , college_code          VARCHAR(10) NOT NULL
    , block_no              VARCHAR(15) NOT NULL
    , subject_code          VARCHAR(10) NOT NULL
    , day                   VARCHAR(10) NOT NULL
    , time                  VARCHAR(20) NOT NULL
    , room                  VARCHAR(10) NOT NULL
    , type                  VARCHAR(10) NOT NULL
    , sequence_no           INTEGER DEFAULT 1
    , employee_id           VARCHAR(10) DEFAULT 'TBA'
    , CONSTRAINT            fk_schedule_syear FOREIGN KEY (syear) REFERENCES SCHOOLYEAR (syear)
    , CONSTRAINT            fk_schedule_semester FOREIGN KEY (semester) REFERENCES SEMESTER (semester)
    , CONSTRAINT            fk_schedule_college FOREIGN KEY (college_code) REFERENCES COLLEGE (college_code)
    , CONSTRAINT            fk_schedule_subject FOREIGN KEY (subject_code) REFERENCES SUBJECT (subject_code)
    , CONSTRAINT            fk_schedule_employee FOREIGN KEY (employee_id) REFERENCES EMPLOYEE (employee_id)
);

CREATE TABLE GRADES (
    grade_id                NUMBER PRIMARY KEY
    , syear                 VARCHAR(9) NOT NULL
    , semester              VARCHAR(1) NOT NULL
    , student_no            INTEGER NOT NULL
    , subject_code          VARCHAR(10) NOT NULL
    , block_no              VARCHAR(15) NOT NULL
    , grade                 DECIMAL(3, 2)
    , CONSTRAINT fk_grades_syear FOREIGN KEY (syear) REFERENCES SCHOOLYEAR (syear)
    , CONSTRAINT fk_grades_semester FOREIGN KEY (semester) REFERENCES SEMESTER (semester)
    , CONSTRAINT fk_grades_student FOREIGN KEY (student_no) REFERENCES STUDENT (student_no)
    , CONSTRAINT fk_grades_subject FOREIGN KEY (subject_code) REFERENCES SUBJECT (subject_code)
);