package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBDelete {

    public static String deleteSchoolYear(String syear) {
        return executeDelete("DELETE FROM SchoolYear WHERE syear = ?", syear, "School Year");
    }

    public static String deleteSemester(String semester) {
        return executeDelete("DELETE FROM Semester WHERE semester = ?", semester, "Semester");
    }

    public static String deleteCollege(String collegeCode) {
        return executeDelete("DELETE FROM College WHERE college_code = ?", collegeCode, "College");
    }

    public static String deleteCourse(String courseCode) {
        return executeDelete("DELETE FROM Course WHERE course_code = ?", courseCode, "Course");
    }

    public static String deleteStudent(String studentNo) {
        return executeDelete("DELETE FROM Student WHERE student_no = ?", studentNo, "Student");
    }

    public static String deleteEmployee(String employeeId) {
        return executeDelete("DELETE FROM Employee WHERE employee_id = ?", employeeId, "Employee");
    }

    public static String deleteSubject(String subjectCode) {
        return executeDelete("DELETE FROM Subject WHERE subject_code = ?", subjectCode, "Subject");
    }

    public static String deleteSchedule(int scheduleId) {
        return executeDelete("DELETE FROM Schedule WHERE schedule_id = ?", scheduleId, "Schedule");
    }

    public static String deleteGrades(int gradeId) {
        return executeDelete("DELETE FROM Grades WHERE grade_id = ?", gradeId, "Grade");
    }

    private static String executeDelete(String sql, Object param, String entityName) {
        Connection conn = DBConnection.getConnection();

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            if (param instanceof String) {
                stmt.setString(1, (String) param);
            } else if (param instanceof Integer) {
                stmt.setInt(1, (Integer) param);
            }

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                return entityName + " deleted successfully.";
            } else {
                return entityName + " not found.";
            }
        } catch (SQLException e) {
            return "Error deleting " + entityName + ": " + e.getMessage();
        }
    }
}
