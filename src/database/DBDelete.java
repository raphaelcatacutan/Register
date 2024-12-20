/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;


/**
 *
 * @author Robante
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBDelete {

    public static String deleteSchoolYear(String syear) {
        Connection conn = DBConnection.getConnection();
        String sql = "DELETE FROM SchoolYear WHERE syear = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, syear);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                return "School Year " + syear + " deleted successfully.";
            } else {
                return "School Year " + syear + " not found.";
            }
        } catch (SQLException e) {
            return "Error deleting School Year: " + e.getMessage();
        }
    }

    public static String deleteSemester(String semester) {
        Connection conn = DBConnection.getConnection();
        String sql = "DELETE FROM Semester WHERE semester = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, semester);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                return "Semester " + semester + " deleted successfully.";
            } else {
                return "Semester " + semester + " not found.";
            }
        } catch (SQLException e) {
            return "Error deleting Semester: " + e.getMessage();
        }
    }

    public static String deleteCollege(String collegeCode) {
        Connection conn = DBConnection.getConnection();
        String sql = "DELETE FROM College WHERE collegeCode = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, collegeCode);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                return "College with code " + collegeCode + " deleted successfully.";
            } else {
                return "College with code " + collegeCode + " not found.";
            }
        } catch (SQLException e) {
            return "Error deleting College: " + e.getMessage();
        }
    }

    public static String deleteCourse(String courseCode) {
        Connection conn = DBConnection.getConnection();
        String sql = "DELETE FROM Course WHERE courseCode = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, courseCode);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                return "Course with code " + courseCode + " deleted successfully.";
            } else {
                return "Course with code " + courseCode + " not found.";
            }
        } catch (SQLException e) {
            return "Error deleting Course: " + e.getMessage();
        }
    }

    public static String deleteStudent(String studentNo) {
        Connection conn = DBConnection.getConnection();
        String sql = "DELETE FROM Student WHERE studentNo = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, studentNo);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                return "Student with ID " + studentNo + " deleted successfully.";
            } else {
                return "Student with ID " + studentNo + " not found.";
            }
        } catch (SQLException e) {
            return "Error deleting Student: " + e.getMessage();
        }
    }

    public static String deleteEmployee(String employeeId) {
        Connection conn = DBConnection.getConnection();
        String sql = "DELETE FROM Employee WHERE employeeId = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, employeeId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                return "Employee with ID " + employeeId + " deleted successfully.";
            } else {
                return "Employee with ID " + employeeId + " not found.";
            }
        } catch (SQLException e) {
            return "Error deleting Employee: " + e.getMessage();
        }
    }

    public static String deleteSubject(String subjectCode) {
        Connection conn = DBConnection.getConnection();
        String sql = "DELETE FROM Subject WHERE subjectCode = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, subjectCode);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                return "Subject with code " + subjectCode + " deleted successfully.";
            } else {
                return "Subject with code " + subjectCode + " not found.";
            }
        } catch (SQLException e) {
            return "Error deleting Subject: " + e.getMessage();
        }
    }

    public static String deleteSchedule(int scheduleId) {
        Connection conn = DBConnection.getConnection();
        String sql = "DELETE FROM Schedule WHERE schedule_id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, scheduleId);  // Using schedule_id for the WHERE clause
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                return "Schedule with ID " + scheduleId + " deleted successfully.";
            } else {
                return "Schedule with ID " + scheduleId + " not found.";
            }
        } catch (SQLException e) {
            return "Error deleting Schedule: " + e.getMessage();
        }
    }


        public static String deleteGrades(int gradeId) {
        Connection conn = DBConnection.getConnection();
        String sql = "DELETE FROM Grades WHERE grade_id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, gradeId);  
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                return "Grade with ID " + gradeId + " deleted successfully.";
            } else {
                return "Grade with ID " + gradeId + " not found.";
            }
        } catch (SQLException e) {
            return "Error deleting Grade: " + e.getMessage();
        }
    }

}

