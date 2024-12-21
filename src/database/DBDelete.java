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
        String sql = "DELETE FROM College WHERE college_code = ?";
        
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
        String sql = "DELETE FROM Course WHERE course_code = ?";
        
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
        String deleteGradesSql = "DELETE FROM GRADES WHERE student_no = ?";
        String deleteStudentSql = "DELETE FROM STUDENT WHERE student_no = ?";

        try {
            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement(deleteGradesSql)) {
                stmt.setString(1, studentNo);
                stmt.executeUpdate();
            }

            try (PreparedStatement stmt = conn.prepareStatement(deleteStudentSql)) {
                stmt.setString(1, studentNo);
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    conn.commit();
                    return "Student with ID " + studentNo + " deleted successfully.";
                } else {
                    conn.rollback();
                    return "Student with ID " + studentNo + " not found.";
                }
            }
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                return "Error rolling back transaction: " + ex.getMessage();
            }
            return "Error deleting Student: " + e.getMessage();
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                return "Error restoring auto-commit mode: " + e.getMessage();
            }
        }
    }


    public static String deleteEmployee(String employeeId) {
        Connection conn = DBConnection.getConnection();
        String deleteScheduleSql = "DELETE FROM SCHEDULE WHERE employee_id = ?";
        String deleteEmployeeSql = "DELETE FROM EMPLOYEE WHERE employee_id = ?";

        try {
            // Begin a transaction to ensure data consistency
            conn.setAutoCommit(false);

            try (PreparedStatement stmt1 = conn.prepareStatement(deleteScheduleSql);
                 PreparedStatement stmt2 = conn.prepareStatement(deleteEmployeeSql)) {

                // Delete from SCHEDULE
                stmt1.setString(1, employeeId);
                stmt1.executeUpdate();

                // Delete from EMPLOYEE
                stmt2.setString(1, employeeId);
                stmt2.executeUpdate();

                // Commit the transaction if both deletions are successful
                conn.commit();
                return "Employee with ID " + employeeId + " deleted successfully.";
            } catch (SQLException e) {
                // Rollback in case of an error during the deletion
                conn.rollback();
                return "Error deleting Employee: " + e.getMessage();
            }
        } catch (SQLException e) {
            // Handle connection or other errors
            try {
                conn.rollback();
            } catch (SQLException ex) {
                return "Error rolling back transaction: " + ex.getMessage();
            }
            return "Error deleting Employee: " + e.getMessage();
        } finally {
            try {
                conn.setAutoCommit(true); // Reset auto-commit to true
                conn.close(); // Ensure the connection is closed after the operation
            } catch (SQLException e) {
                return "Error resetting auto-commit or closing connection: " + e.getMessage();
            }
        }
    }

    public static String deleteSubject(String subjectCode) {
        Connection conn = DBConnection.getConnection();
        String sql = "DELETE FROM Subject WHERE subject_code = ?";
        
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

