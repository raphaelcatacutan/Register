package database;

import java.sql.*;
import java.util.Date;

public class DBUpdate {

    private Connection connection;

    public DBUpdate(Connection connection) {
        this.connection = connection;
    }

    public void updateSchoolYear(String syear) throws SQLException {
        String query = "UPDATE SchoolYear SET syear = ? WHERE syear = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, syear);
            stmt.setString(2, syear);
            stmt.executeUpdate();
        }
    }

    public void updateSemester(String semester) throws SQLException {
        String query = "UPDATE Semester SET semester = ? WHERE semester = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, semester);
            stmt.setString(2, semester);
            stmt.executeUpdate();
        }
    }

    public void updateCollege(String collegeCode, String description, Date dateOpened, Date dateClosed, String status) throws SQLException {
        String query = "UPDATE College SET description = ?, dateOpened = ?, dateClosed = ?, status = ? WHERE collegeCode = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, description);
            stmt.setDate(2, new java.sql.Date(dateOpened.getTime()));
            stmt.setDate(3, new java.sql.Date(dateClosed.getTime()));
            stmt.setString(4, status);
            stmt.setString(5, collegeCode);
            stmt.executeUpdate();
        }
    }

    public void updateCourse(String courseCode, String description, String collegeCode, Date dateOpened, Date dateClosed, String status) throws SQLException {
        String query = "UPDATE Course SET description = ?, collegeCode = ?, dateOpened = ?, dateClosed = ?, status = ? WHERE courseCode = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, description);
            stmt.setString(2, collegeCode);
            stmt.setDate(3, new java.sql.Date(dateOpened.getTime()));
            stmt.setDate(4, new java.sql.Date(dateClosed.getTime()));
            stmt.setString(5, status);
            stmt.setString(6, courseCode);
            stmt.executeUpdate();
        }
    }

    public void updateStudent(String studentNo, String lastname, String firstname, String email, char gender, String courseCode, String cpNum, String address, Date bday, String status, Date dateStarted, Date dateGraduated) throws SQLException {
        String query = "UPDATE Student SET lastname = ?, firstname = ?, email = ?, gender = ?, courseCode = ?, cpNum = ?, address = ?, bday = ?, status = ?, dateStarted = ?, dateGraduated = ? WHERE studentNo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, lastname);
            stmt.setString(2, firstname);
            stmt.setString(3, email);
            stmt.setString(4, String.valueOf(gender));
            stmt.setString(5, courseCode);
            stmt.setString(6, cpNum);
            stmt.setString(7, address);
            stmt.setDate(8, new java.sql.Date(bday.getTime()));
            stmt.setString(9, status);
            stmt.setDate(10, new java.sql.Date(dateStarted.getTime()));
            stmt.setDate(11, new java.sql.Date(dateGraduated.getTime()));
            stmt.setString(12, studentNo);
            stmt.executeUpdate();
        }
    }

    public void updateEmployee(String employeeId, String lastname, String firstname, String email, char gender, String cpNum, String address, Date bday, String status, Date dateStarted, Date dateResigned) throws SQLException {
        String query = "UPDATE Employee SET lastname = ?, firstname = ?, email = ?, gender = ?, cpNum = ?, address = ?, bday = ?, status = ?, dateStarted = ?, dateResigned = ? WHERE employeeId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, lastname);
            stmt.setString(2, firstname);
            stmt.setString(3, email);
            stmt.setString(4, String.valueOf(gender));
            stmt.setString(5, cpNum);
            stmt.setString(6, address);
            stmt.setDate(7, new java.sql.Date(bday.getTime()));
            stmt.setString(8, status);
            stmt.setDate(9, new java.sql.Date(dateStarted.getTime()));
            stmt.setDate(10, new java.sql.Date(dateResigned.getTime()));
            stmt.setString(11, employeeId);
            stmt.executeUpdate();
        }
    }

    public void updateSubject(String subjectCode, String description, int units, String curriculum, String collegeCode, String status, Date dateOpened, Date dateClosed) throws SQLException {
        String query = "UPDATE Subject SET description = ?, units = ?, curriculum = ?, collegeCode = ?, status = ?, dateOpened = ?, dateClosed = ? WHERE subjectCode = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, description);
            stmt.setInt(2, units);
            stmt.setString(3, curriculum);
            stmt.setString(4, collegeCode);
            stmt.setString(5, status);
            stmt.setDate(6, new java.sql.Date(dateOpened.getTime()));
            stmt.setDate(7, new java.sql.Date(dateClosed.getTime()));
            stmt.setString(8, subjectCode);
            stmt.executeUpdate();
        }
    }

    public void updateSchedule(String syear, String semester, String collegeCode, String blockNo, String subjectCode, String day, String time, String room, String type, int sequenceNo, String employeeId) throws SQLException {
        String query = "UPDATE Schedule SET semester = ?, collegeCode = ?, blockNo = ?, subjectCode = ?, day = ?, time = ?, room = ?, type = ?, sequenceNo = ?, employeeId = ? WHERE syear = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, semester);
            stmt.setString(2, collegeCode);
            stmt.setString(3, blockNo);
            stmt.setString(4, subjectCode);
            stmt.setString(5, day);
            stmt.setString(6, time);
            stmt.setString(7, room);
            stmt.setString(8, type);
            stmt.setInt(9, sequenceNo);
            stmt.setString(10, employeeId);
            stmt.setString(11, syear);
            stmt.executeUpdate();
        }
    }

    public void updateGrades(String syear, String semester, String studentNo, String subjectCode, String blockNo, double grade) throws SQLException {
        String query = "UPDATE Grades SET semester = ?, subjectCode = ?, blockNo = ?, grade = ? WHERE syear = ? AND studentNo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, semester);
            stmt.setString(2, subjectCode);
            stmt.setString(3, blockNo);
            stmt.setDouble(4, grade);
            stmt.setString(5, syear);
            stmt.setString(6, studentNo);
            stmt.executeUpdate();
        }
    }
}
