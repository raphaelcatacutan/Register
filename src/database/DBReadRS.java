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
        String query = "SELECT * FROM College WHERE college_code = ?";
        PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query); // Use getConnection() to get the connection
        stmt.setString(1, collegeCode);
        return stmt.executeQuery();
    }

    public static ResultSet getCourseData(String courseCode) throws SQLException {
        String query = "SELECT * FROM Course WHERE course_code = ?";
        PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query); // Use getConnection() to get the connection
        stmt.setString(1, courseCode);
        return stmt.executeQuery();
    }

    public static ResultSet getStudentData(String studentNo) throws SQLException {
        String query = "SELECT * FROM Student WHERE student_no = ?";
        PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query); // Use getConnection() to get the connection
        stmt.setString(1, studentNo);
        return stmt.executeQuery();
    }

    public static ResultSet getEmployeeData(String employeeId) throws SQLException {
        String query = "SELECT * FROM Employee WHERE employee_id = ?";
        PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query); // Use getConnection() to get the connection
        stmt.setString(1, employeeId);
        return stmt.executeQuery();
    }

    public static ResultSet getSubjectData(String subjectCode) throws SQLException {
        String query = "SELECT * FROM Subject WHERE subject_code = ?";
        PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query); // Use getConnection() to get the connection
        stmt.setString(1, subjectCode);
        return stmt.executeQuery();
    }

    public static ResultSet getScheduleData(int schedule_id) throws SQLException {
        String query = "SELECT * FROM Schedule WHERE schedule_id = ?";
        PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query); // Use getConnection() to get the connection
        stmt.setInt(1, schedule_id);
        return stmt.executeQuery();
    }

    public static ResultSet getGradesData(int grade_id) throws SQLException {
        String query = "SELECT * FROM Grades WHERE grade_id = ?";
        PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query); // Use getConnection() to get the connection
        stmt.setInt(1, grade_id);
        return stmt.executeQuery();
    }
    
    public static void main(String[] args) throws SQLException {
        // Get the metadata to get the column names
        
        ResultSet resultSet = getScheduleData(1);
        ResultSetMetaData rsMetaData = resultSet.getMetaData();
        int columnCount = rsMetaData.getColumnCount();

        // Print column headers
        for (int i = 1; i <= columnCount; i++) {
            System.out.print(rsMetaData.getColumnLabel(i) + "\t");
        }
        System.out.println();

        // Iterate through the ResultSet and print each row
        while (resultSet.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(resultSet.getString(i) + "\t");
            }
            System.out.println();
        }
    }
}
