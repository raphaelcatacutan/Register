package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.*;

/**
 *
 * @author Robante
 */
public class DBReadMd {

    public static SchoolYear getSchoolYear(String syear) {
        String query = "SELECT * FROM SchoolYear WHERE syear = ?";
        try (PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query)) {
            stmt.setString(1, syear);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                SchoolYear schoolYear = new SchoolYear();
                schoolYear.setSyear(rs.getString("syear"));
                return schoolYear;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Semester getSemester(String semester) {
        String query = "SELECT * FROM Semester WHERE semester = ?";
        try (PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query)) {
            stmt.setString(1, semester);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Semester sem = new Semester();
                sem.setSemester(rs.getString("semester"));
                return sem;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static College getCollege(String collegeCode) {
        String query = "SELECT * FROM College WHERE collegeCode = ?";
        try (PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query)) {
            stmt.setString(1, collegeCode);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                College college = new College();
                college.setCollegeCode(rs.getString("collegeCode"));
                college.setDescription(rs.getString("description"));
                college.setDateOpened(rs.getDate("dateOpened"));
                college.setDateClosed(rs.getDate("dateClosed"));
                college.setStatus(rs.getString("status"));
                return college;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Course getCourse(String courseCode) {
        String query = "SELECT * FROM Course WHERE courseCode = ?";
        try (PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query)) {
            stmt.setString(1, courseCode);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Course course = new Course();
                course.setCourseCode(rs.getString("courseCode"));
                course.setDescription(rs.getString("description"));
                course.setCollegeCode(rs.getString("collegeCode"));
                course.setDateOpened(rs.getDate("dateOpened"));
                course.setDateClosed(rs.getDate("dateClosed"));
                course.setStatus(rs.getString("status"));
                return course;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Student getStudent(String studentNo) {
        String query = "SELECT * FROM Student WHERE studentNo = ?";
        try (PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query)) {
            stmt.setString(1, studentNo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setStudentNo(rs.getString("studentNo"));
                student.setLastname(rs.getString("lastname"));
                student.setFirstname(rs.getString("firstname"));
                student.setEmail(rs.getString("email"));
                student.setGender(rs.getString("gender").charAt(0));
                student.setCourseCode(rs.getString("courseCode"));
                student.setCpNum(rs.getString("cpNum"));
                student.setAddress(rs.getString("address"));
                student.setBday(rs.getDate("bday"));
                student.setStatus(rs.getString("status"));
                student.setDateStarted(rs.getDate("dateStarted"));
                student.setDateGraduated(rs.getDate("dateGraduated"));
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Employee getEmployee(String employeeId) {
        String query = "SELECT * FROM Employee WHERE employeeId = ?";
        try (PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query)) {
            stmt.setString(1, employeeId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getString("employeeId"));
                employee.setLastname(rs.getString("lastname"));
                employee.setFirstname(rs.getString("firstname"));
                employee.setEmail(rs.getString("email"));
                employee.setGender(rs.getString("gender").charAt(0));
                employee.setCpNum(rs.getString("cpNum"));
                employee.setAddress(rs.getString("address"));
                employee.setBday(rs.getDate("bday"));
                employee.setStatus(rs.getString("status"));
                employee.setDateStarted(rs.getDate("dateStarted"));
                employee.setDateResigned(rs.getDate("dateResigned"));
                return employee;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Subject getSubject(String subjectCode) {
        String query = "SELECT * FROM Subject WHERE subjectCode = ?";
        try (PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query)) {
            stmt.setString(1, subjectCode);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Subject subject = new Subject();
                subject.setSubjectCode(rs.getString("subjectCode"));
                subject.setDescription(rs.getString("description"));
                subject.setUnits(rs.getInt("units"));
                subject.setCurriculum(rs.getString("curriculum"));
                subject.setCollegeCode(rs.getString("collegeCode"));
                subject.setStatus(rs.getString("status"));
                subject.setDateOpened(rs.getDate("dateOpened"));
                subject.setDateClosed(rs.getDate("dateClosed"));
                return subject;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Schedule> getSchedules(String syear, String semester) {
        String query = "SELECT * FROM Schedule WHERE syear = ? AND semester = ?";
        List<Schedule> schedules = new ArrayList<>();
        try (PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query)) {
            stmt.setString(1, syear);
            stmt.setString(2, semester);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Schedule schedule = new Schedule();
                schedule.setSyear(rs.getString("syear"));
                schedule.setSemester(rs.getString("semester"));
                schedule.setCollegeCode(rs.getString("collegeCode"));
                schedule.setBlockNo(rs.getString("blockNo"));
                schedule.setSubjectCode(rs.getString("subjectCode"));
                schedule.setDay(rs.getString("day"));
                schedule.setTime(rs.getString("time"));
                schedule.setRoom(rs.getString("room"));
                schedule.setType(rs.getString("type"));
                schedule.setSequenceNo(rs.getInt("sequenceNo"));
                schedule.setEmployeeId(rs.getString("employeeId"));
                schedules.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedules;
    }

    public static List<Grades> getGrades(String syear, String semester, String studentNo) {
        String query = "SELECT * FROM Grades WHERE syear = ? AND semester = ? AND studentNo = ?";
        List<Grades> gradesList = new ArrayList<>();
        try (PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query)) {
            stmt.setString(1, syear);
            stmt.setString(2, semester);
            stmt.setString(3, studentNo);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Grades grades = new Grades();
                grades.setSyear(rs.getString("syear"));
                grades.setSemester(rs.getString("semester"));
                grades.setStudentNo(rs.getString("studentNo"));
                grades.setSubjectCode(rs.getString("subjectCode"));
                grades.setBlockNo(rs.getString("blockNo"));
                grades.setGrade(rs.getDouble("grade"));
                gradesList.add(grades);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gradesList;
    }
}
