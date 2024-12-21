package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import models.*;

public class DBAdd {

    public static String addSchoolYear(String syear) {
        String query = "INSERT INTO SchoolYear (syear) VALUES (?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, syear);
            stmt.executeUpdate();
            return "School Year added successfully!";
        } catch (SQLException e) {
            return "Error adding School Year: " + e.getMessage();
        }
    }

    public static String addSemester(String semester) {
        String query = "INSERT INTO Semester (semester) VALUES (?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, semester);
            stmt.executeUpdate();
            return "Semester added successfully!";
        } catch (SQLException e) {
            return "Error adding Semester: " + e.getMessage();
        }
    }

    public static String addCollege(String collegeCode, String description, Date dateOpened, Date dateClosed, String status) {
        String query = "INSERT INTO College (collegeCode, description, dateOpened, dateClosed, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, collegeCode);
            stmt.setString(2, description);
            stmt.setDate(3, new java.sql.Date(dateOpened.getTime()));
            stmt.setDate(4, dateClosed != null ? new java.sql.Date(dateClosed.getTime()) : null);
            stmt.setString(5, status);
            stmt.executeUpdate();
            return "College added successfully!";
        } catch (SQLException e) {
            return "Error adding College: " + e.getMessage();
        }
    }

    public static String addCourse(String courseCode, String description, String collegeCode, Date dateOpened, Date dateClosed, String status) {
        String query = "INSERT INTO Course (courseCode, description, collegeCode, dateOpened, dateClosed, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, courseCode);
            stmt.setString(2, description);
            stmt.setString(3, collegeCode);
            stmt.setDate(4, new java.sql.Date(dateOpened.getTime()));
            stmt.setDate(5, dateClosed != null ? new java.sql.Date(dateClosed.getTime()) : null);
            stmt.setString(6, status);
            stmt.executeUpdate();
            return "Course added successfully!";
        } catch (SQLException e) {
            return "Error adding Course: " + e.getMessage();
        }
    }

    public static String addStudent(String studentNo, String lastname, String firstname, String email, String courseCode, char gender, String cpNum, String address, String status, Date bday, Date dateStarted, Date dateGraduated) {
        String query = "INSERT INTO STUDENT (student_no, lastname, firstname, email, gender, course_code, cp_num, address, bday, status, date_started, date_graduated) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, studentNo);
            stmt.setString(2, lastname);
            stmt.setString(3, firstname);
            stmt.setString(4, email);
            stmt.setString(5, String.valueOf(gender));
            stmt.setString(6, courseCode);
            stmt.setString(7, cpNum); 
            stmt.setString(8, address);
            stmt.setDate(9, new java.sql.Date(bday.getTime()));
            stmt.setString(10, status != null ? status : "A");
            stmt.setDate(11, new java.sql.Date(dateStarted.getTime()));
            stmt.setDate(12, dateGraduated != null ? new java.sql.Date(dateGraduated.getTime()) : null);
            stmt.executeUpdate();
            return "Student added successfully!";
        } catch (SQLException e) {
            return "Error adding Student: " + e.getMessage();
        }
    }


    public static String addEmployee(String employeeId, String lastname, String firstname, String email, char gender, String cpNum, String address, Date bday, String status, Date dateStarted, Date dateResigned) {
        String query = "INSERT INTO Employee (employee_id, lastname, firstname, email, gender, cp_num, address, bday, status, date_started, date_resigned) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, employeeId);
            stmt.setString(2, lastname);
            stmt.setString(3, firstname);
            stmt.setString(4, email);
            stmt.setString(5, String.valueOf(gender));
            stmt.setString(6, cpNum);
            stmt.setString(7, address);
            stmt.setDate(8, new java.sql.Date(bday.getTime()));
            stmt.setString(9, status);
            stmt.setDate(10, new java.sql.Date(dateStarted.getTime()));
            stmt.setDate(11, dateResigned != null ? new java.sql.Date(dateResigned.getTime()) : null);
            stmt.executeUpdate();
            return "Employee added successfully!";
        } catch (SQLException e) {
            return "Error adding Employee: " + e.getMessage();
        }
    }

    public static String addSubject(String subjectCode, String description, int units, String curriculum, String collegeCode, String status, Date dateOpened, Date dateClosed) {
        String query = "INSERT INTO Subject (subjectCode, description, units, curriculum, collegeCode, status, dateOpened, dateClosed) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, subjectCode);
            stmt.setString(2, description);
            stmt.setInt(3, units);
            stmt.setString(4, curriculum);
            stmt.setString(5, collegeCode);
            stmt.setString(6, status);
            stmt.setDate(7, new java.sql.Date(dateOpened.getTime()));
            stmt.setDate(8, dateClosed != null ? new java.sql.Date(dateClosed.getTime()) : null);
            stmt.executeUpdate();
            return "Subject added successfully!";
        } catch (SQLException e) {
            return "Error adding Subject: " + e.getMessage();
        }
    }

    public static String addSchedule(String syear, String semester, String collegeCode, String blockNo, String subjectCode, String day, String time, String room, String type, int sequenceNo, String employeeId) {
        String query = "INSERT INTO Schedule (syear, semester, collegeCode, blockNo, subjectCode, day, time, room, type, sequenceNo, employeeId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, syear);
            stmt.setString(2, semester);
            stmt.setString(3, collegeCode);
            stmt.setString(4, blockNo);
            stmt.setString(5, subjectCode);
            stmt.setString(6, day);
            stmt.setString(7, time);
            stmt.setString(8, room);
            stmt.setString(9, type);
            stmt.setInt(10, sequenceNo);
            stmt.setString(11, employeeId);
            stmt.executeUpdate();
            return "Schedule added successfully!";
        } catch (SQLException e) {
            return "Error adding Schedule: " + e.getMessage();
        }
    }

    public static String addGrade(String syear, String semester, int studentNo, String subjectCode, String blockNo, double grade) {
        String query = "INSERT INTO GRADES (syear, semester, student_no, subject_code, block_no, grade) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, syear);
            stmt.setString(2, semester);
            stmt.setInt(3, studentNo);
            stmt.setString(4, subjectCode);
            stmt.setString(5, blockNo);
            stmt.setDouble(6, grade);
            stmt.executeUpdate();
            return "Grade added successfully!";
        } catch (SQLException e) {
            return "Error adding Grade: " + e.getMessage();
        }
    }
}
