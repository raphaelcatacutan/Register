package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import models.*;
/**
 *
 * @author Robante
 */
public class DBAdd {

    public static String addSchoolYear(SchoolYear schoolYear, Connection conn) {
        String query = "INSERT INTO SchoolYear (syear) VALUES (?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, schoolYear.getSyear());
            stmt.executeUpdate();
            return "School Year added successfully!";
        } catch (SQLException e) {
            return "Error adding School Year: " + e.getMessage();
        }
    }

    public static String addSemester(Semester semester, Connection conn) {
        String query = "INSERT INTO Semester (semester) VALUES (?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, semester.getSemester());
            stmt.executeUpdate();
            return "Semester added successfully!";
        } catch (SQLException e) {
            return "Error adding Semester: " + e.getMessage();
        }
    }

    public static String addCollege(College college, Connection conn) {
        String query = "INSERT INTO College (collegeCode, description, dateOpened, dateClosed, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, college.getCollegeCode());
            stmt.setString(2, college.getDescription());
            stmt.setDate(3, new java.sql.Date(college.getDateOpened().getTime()));
            stmt.setDate(4, college.getDateClosed() != null ? new java.sql.Date(college.getDateClosed().getTime()) : null);
            stmt.setString(5, college.getStatus());
            stmt.executeUpdate();
            return "College added successfully!";
        } catch (SQLException e) {
            return "Error adding College: " + e.getMessage();
        }
    }

    public static String addCourse(Course course, Connection conn) {
        String query = "INSERT INTO Course (courseCode, description, collegeCode, dateOpened, dateClosed, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, course.getCourseCode());
            stmt.setString(2, course.getDescription());
            stmt.setString(3, course.getCollegeCode());
            stmt.setDate(4, new java.sql.Date(course.getDateOpened().getTime()));
            stmt.setDate(5, course.getDateClosed() != null ? new java.sql.Date(course.getDateClosed().getTime()) : null);
            stmt.setString(6, course.getStatus());
            stmt.executeUpdate();
            return "Course added successfully!";
        } catch (SQLException e) {
            return "Error adding Course: " + e.getMessage();
        }
    }

    public static String addStudent(Student student, Connection conn) {
        String query = "INSERT INTO Student (studentNo, lastname, firstname, email, gender, courseCode, cpNum, address, bday, status, dateStarted, dateGraduated) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, student.getStudentNo());
            stmt.setString(2, student.getLastname());
            stmt.setString(3, student.getFirstname());
            stmt.setString(4, student.getEmail());
            stmt.setString(5, String.valueOf(student.getGender()));
            stmt.setString(6, student.getCourseCode());
            stmt.setString(7, student.getCpNum());
            stmt.setString(8, student.getAddress());
            stmt.setDate(9, new java.sql.Date(student.getBday().getTime()));
            stmt.setString(10, student.getStatus());
            stmt.setDate(11, new java.sql.Date(student.getDateStarted().getTime()));
            stmt.setDate(12, student.getDateGraduated() != null ? new java.sql.Date(student.getDateGraduated().getTime()) : null);
            stmt.executeUpdate();
            return "Student added successfully!";
        } catch (SQLException e) {
            return "Error adding Student: " + e.getMessage();
        }
    }

    public static String addEmployee(Employee employee, Connection conn) {
        String query = "INSERT INTO Employee (employeeId, lastname, firstname, email, gender, cpNum, address, bday, status, dateStarted, dateResigned) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, employee.getEmployeeId());
            stmt.setString(2, employee.getLastname());
            stmt.setString(3, employee.getFirstname());
            stmt.setString(4, employee.getEmail());
            stmt.setString(5, String.valueOf(employee.getGender()));
            stmt.setString(6, employee.getCpNum());
            stmt.setString(7, employee.getAddress());
            stmt.setDate(8, new java.sql.Date(employee.getBday().getTime()));
            stmt.setString(9, employee.getStatus());
            stmt.setDate(10, new java.sql.Date(employee.getDateStarted().getTime()));
            stmt.setDate(11, employee.getDateResigned() != null ? new java.sql.Date(employee.getDateResigned().getTime()) : null);
            stmt.executeUpdate();
            return "Employee added successfully!";
        } catch (SQLException e) {
            return "Error adding Employee: " + e.getMessage();
        }
    }

    public static String addSubject(Subject subject, Connection conn) {
        String query = "INSERT INTO Subject (subjectCode, description, units, curriculum, collegeCode, status, dateOpened, dateClosed) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, subject.getSubjectCode());
            stmt.setString(2, subject.getDescription());
            stmt.setInt(3, subject.getUnits());
            stmt.setString(4, subject.getCurriculum());
            stmt.setString(5, subject.getCollegeCode());
            stmt.setString(6, subject.getStatus());
            stmt.setDate(7, new java.sql.Date(subject.getDateOpened().getTime()));
            stmt.setDate(8, subject.getDateClosed() != null ? new java.sql.Date(subject.getDateClosed().getTime()) : null);
            stmt.executeUpdate();
            return "Subject added successfully!";
        } catch (SQLException e) {
            return "Error adding Subject: " + e.getMessage();
        }
    }

    public static String addSchedule(Schedule schedule, Connection conn) {
        String query = "INSERT INTO Schedule (syear, semester, collegeCode, blockNo, subjectCode, day, time, room, type, sequenceNo, employeeId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, schedule.getSyear());
            stmt.setString(2, schedule.getSemester());
            stmt.setString(3, schedule.getCollegeCode());
            stmt.setString(4, schedule.getBlockNo());
            stmt.setString(5, schedule.getSubjectCode());
            stmt.setString(6, schedule.getDay());
            stmt.setString(7, schedule.getTime());
            stmt.setString(8, schedule.getRoom());
            stmt.setString(9, schedule.getType());
            stmt.setInt(10, schedule.getSequenceNo());
            stmt.setString(11, schedule.getEmployeeId());
            stmt.executeUpdate();
            return "Schedule added successfully!";
        } catch (SQLException e) {
            return "Error adding Schedule: " + e.getMessage();
        }
    }

    public static String addGrade(Grades grade, Connection conn) {
        String query = "INSERT INTO Grades (syear, semester, studentNo, subjectCode, blockNo, grade) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, grade.getSyear());
            stmt.setString(2, grade.getSemester());
            stmt.setString(3, grade.getStudentNo());
            stmt.setString(4, grade.getSubjectCode());
            stmt.setString(5, grade.getBlockNo());
            stmt.setDouble(6, grade.getGrade());
            stmt.executeUpdate();
            return "Grade added successfully!";
        } catch (SQLException e) {
            return "Error adding Grade: " + e.getMessage();
        }
    }
}
