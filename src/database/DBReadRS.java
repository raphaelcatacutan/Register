package database;

import java.sql.*;

/**
 *
 * @author Robante
 */
public class DBReadRS {

    public static ResultSet getSchoolYearData(String syear) throws SQLException {
        String query = "SELECT * FROM SchoolYear WHERE syear = ?";
        PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query); // Use getConnection() to get the connection
        stmt.setString(1, syear);
        return stmt.executeQuery();
    }

    public static ResultSet getSemesterData(String semester) throws SQLException {
        String query = "SELECT * FROM Semester WHERE semester = ?";
        PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query); // Use getConnection() to get the connection
        stmt.setString(1, semester);
        return stmt.executeQuery();
    }

    public static ResultSet getCollegeData(String collegeCode) throws SQLException {
        String query = "SELECT * FROM College WHERE collegeCode = ?";
        PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query); // Use getConnection() to get the connection
        stmt.setString(1, collegeCode);
        return stmt.executeQuery();
    }

    public static ResultSet getCourseData(String courseCode) throws SQLException {
        String query = "SELECT * FROM Course WHERE courseCode = ?";
        PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query); // Use getConnection() to get the connection
        stmt.setString(1, courseCode);
        return stmt.executeQuery();
    }

    public static ResultSet getStudentData(String studentNo) throws SQLException {
        String query = "SELECT * FROM Student WHERE studentNo = ?";
        PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query); // Use getConnection() to get the connection
        stmt.setString(1, studentNo);
        return stmt.executeQuery();
    }

    public static ResultSet getEmployeeData(String employeeId) throws SQLException {
        String query = "SELECT * FROM Employee WHERE employeeId = ?";
        PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query); // Use getConnection() to get the connection
        stmt.setString(1, employeeId);
        return stmt.executeQuery();
    }

    public static ResultSet getSubjectData(String subjectCode) throws SQLException {
        String query = "SELECT * FROM Subject WHERE subjectCode = ?";
        PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query); // Use getConnection() to get the connection
        stmt.setString(1, subjectCode);
        return stmt.executeQuery();
    }

    public static ResultSet getScheduleData(String syear, String semester, String collegeCode) throws SQLException {
        String query = "SELECT * FROM Schedule WHERE syear = ? AND semester = ? AND collegeCode = ?";
        PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query); // Use getConnection() to get the connection
        stmt.setString(1, syear);
        stmt.setString(2, semester);
        stmt.setString(3, collegeCode);
        return stmt.executeQuery();
    }

    public static ResultSet getGradesData(String syear, String semester, String studentNo) throws SQLException {
        String query = "SELECT * FROM Grades WHERE syear = ? AND semester = ? AND studentNo = ?";
        PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query); // Use getConnection() to get the connection
        stmt.setString(1, syear);
        stmt.setString(2, semester);
        stmt.setString(3, studentNo);
        return stmt.executeQuery();
    }
}
