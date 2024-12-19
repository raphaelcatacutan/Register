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

    public static List<SchoolYear> getSchoolYears(String syear) {
        String query = "SELECT * FROM SchoolYear WHERE syear = ?";
        List<SchoolYear> schoolYears = new ArrayList<>();
        try (PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query)) {
            stmt.setString(1, syear);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                schoolYears.add(extractSchoolYear(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schoolYears;
    }

    public static List<Semester> getSemesters(String semester) {
        String query = "SELECT * FROM Semester WHERE semester = ?";
        List<Semester> semesters = new ArrayList<>();
        try (PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query)) {
            stmt.setString(1, semester);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                semesters.add(extractSemester(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return semesters;
    }

    public static List<College> getColleges(String status) {
        String query = "SELECT * FROM College WHERE status = ?";
        List<College> colleges = new ArrayList<>();
        try (PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query)) {
            stmt.setString(1, status);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                colleges.add(extractCollege(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return colleges;
    }

    public static List<Course> getCourses(String collegeCode) {
        String query = "SELECT * FROM Course WHERE collegeCode = ?";
        List<Course> courses = new ArrayList<>();
        try (PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query)) {
            stmt.setString(1, collegeCode);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                courses.add(extractCourse(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    public static List<Student> getStudents(String courseCode) {
        String query = "SELECT * FROM Student WHERE courseCode = ?";
        List<Student> students = new ArrayList<>();
        try (PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query)) {
            stmt.setString(1, courseCode);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                students.add(extractStudent(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static List<Employee> getEmployees(String status) {
        String query = "SELECT * FROM Employee WHERE status = ?";
        List<Employee> employees = new ArrayList<>();
        try (PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query)) {
            stmt.setString(1, status);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                employees.add(extractEmployee(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public static List<Subject> getSubjects(String curriculum) {
        String query = "SELECT * FROM Subject WHERE curriculum = ?";
        List<Subject> subjects = new ArrayList<>();
        try (PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query)) {
            stmt.setString(1, curriculum);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                subjects.add(extractSubject(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subjects;
    }

    public static List<Schedule> getSchedules(String syear, String semester) {
        String query = "SELECT * FROM Schedule WHERE syear = ? AND semester = ?";
        List<Schedule> schedules = new ArrayList<>();
        try (PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query)) {
            stmt.setString(1, syear);
            stmt.setString(2, semester);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                schedules.add(extractSchedule(rs));
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
                gradesList.add(extractGrades(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gradesList;
    }

    //extract methodz
    private static SchoolYear extractSchoolYear(ResultSet rs) throws SQLException {
        SchoolYear schoolYear = new SchoolYear();
        schoolYear.setSyear(rs.getString("syear"));
        return schoolYear;
    }

    private static Semester extractSemester(ResultSet rs) throws SQLException {
        Semester semester = new Semester();
        semester.setSemester(rs.getString("semester"));
        return semester;
    }

    private static College extractCollege(ResultSet rs) throws SQLException {
        College college = new College();
        college.setCollegeCode(rs.getString("collegeCode"));
        college.setDescription(rs.getString("description"));
        college.setDateOpened(rs.getDate("dateOpened"));
        college.setDateClosed(rs.getDate("dateClosed"));
        college.setStatus(rs.getString("status"));
        return college;
    }

    private static Course extractCourse(ResultSet rs) throws SQLException {
        Course course = new Course();
        course.setCourseCode(rs.getString("courseCode"));
        course.setDescription(rs.getString("description"));
        course.setCollegeCode(rs.getString("collegeCode"));
        course.setDateOpened(rs.getDate("dateOpened"));
        course.setDateClosed(rs.getDate("dateClosed"));
        course.setStatus(rs.getString("status"));
        return course;
    }

    private static Student extractStudent(ResultSet rs) throws SQLException {
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

    private static Employee extractEmployee(ResultSet rs) throws SQLException {
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

    private static Subject extractSubject(ResultSet rs) throws SQLException {
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

    private static Schedule extractSchedule(ResultSet rs) throws SQLException {
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
        return schedule;
    }

    private static Grades extractGrades(ResultSet rs) throws SQLException {
        Grades grades = new Grades();
        grades.setSyear(rs.getString("syear"));
        grades.setSemester(rs.getString("semester"));
        grades.setStudentNo(rs.getString("studentNo"));
        grades.setSubjectCode(rs.getString("subjectCode"));
        grades.setBlockNo(rs.getString("blockNo"));
        grades.setGrade(rs.getDouble("grade"));
        return grades;
    }
}