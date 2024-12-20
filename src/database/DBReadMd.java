package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.*;

public class DBReadMd {

    public static List<SchoolYear> readSchoolYears() {
        List<SchoolYear> schoolYears = new ArrayList<>();
        String query = "SELECT * FROM SchoolYear";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                SchoolYear sy = new SchoolYear();
                sy.setSyear(rs.getString("year"));
                schoolYears.add(sy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schoolYears;
    }

    public static List<Semester> readSemesters() {
        List<Semester> semesters = new ArrayList<>();
        String query = "SELECT * FROM Semester";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Semester semester = new Semester();
                semester.setSemester(rs.getString("name"));
                semesters.add(semester);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return semesters;
    }

    public static List<College> readColleges() {
        List<College> colleges = new ArrayList<>();
        String query = "SELECT * FROM College";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                College college = new College();
                college.setCollegeCode(rs.getString("college_code"));
                college.setDescription(rs.getString("description"));
                college.setDateOpened(rs.getDate("date_opened"));
                college.setDateClosed(rs.getDate("date_closed"));
                college.setStatus(rs.getString("status"));
                colleges.add(college);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return colleges;
    }

    // Read all Course records
    public static List<Course> readCourses() {
    List<Course> courses = new ArrayList<>();
    String query = "SELECT * FROM Course";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            Course course = new Course();
            course.setCourseCode(rs.getString("course_code"));
            course.setDescription(rs.getString("description"));
            course.setCollegeCode(rs.getString("college_code"));
            course.setDateOpened(rs.getDate("date_opened"));
            course.setDateClosed(rs.getDate("date_closed"));
            course.setStatus(rs.getString("status"));
            courses.add(course);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return courses;
}

    public static List<Student> readStudents() {
    List<Student> students = new ArrayList<>();
    String query = "SELECT * FROM STUDENT";  // Corrected table name to match your schema
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            Student student = new Student();
            student.setStudentNo(rs.getInt("student_no"));  // Changed to int
            student.setLastname(rs.getString("lastname"));
            student.setFirstname(rs.getString("firstname"));
            student.setEmail(rs.getString("email"));
            student.setGender(rs.getString("gender"));  // Assuming gender is a single character
            student.setCourseCode(rs.getString("course_code"));
            student.setCpNum(rs.getInt("cp_num"));
            student.setAddress(rs.getString("address"));
            
            // Handling potential null values for dates
            student.setBday(rs.getDate("bday"));
            student.setStatus(rs.getString("status"));
            student.setDateStarted(rs.getDate("date_started"));
            student.setDateGraduated(rs.getDate("date_graduated"));
            
            students.add(student);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return students;
}


    public static List<Employee> readEmployees() {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM Employee";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getString("employee_id"));
                employee.setLastname(rs.getString("lastname"));
                employee.setFirstname(rs.getString("firstname"));
                employee.setEmail(rs.getString("email"));
                employee.setGender(rs.getString("gender"));
                employee.setCpNum(rs.getString("cp_num"));
                employee.setAddress(rs.getString("address"));
                employee.setBday(rs.getDate("bday"));
                employee.setStatus(rs.getString("status"));
                employee.setDateStarted(rs.getDate("date_started"));
                employee.setDateResigned(rs.getDate("date_resigned"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
    

    public static List<Subject> readSubjects() {
        List<Subject> subjects = new ArrayList<>();
        String query = "SELECT * FROM Subject";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Subject subject = new Subject();
                subject.setSubjectCode(rs.getString("subject_code"));
                subject.setDescription(rs.getString("description"));
                subject.setUnits(rs.getInt("units"));
                subject.setCurriculum(rs.getString("curriculum"));
                subject.setCollegeCode(rs.getString("college_code"));
                subject.setStatus(rs.getString("status"));
                subject.setDateOpened(rs.getDate("date_opened"));
                subject.setDateClosed(rs.getDate("date_closed"));
                subjects.add(subject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subjects;
    }


    // Read all Schedule records
    public static List<Schedule> readSchedules() {
        List<Schedule> schedules = new ArrayList<>();
        String query = "SELECT * FROM Schedule";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Schedule schedule = new Schedule();
                schedule.setScheduleId(rs.getInt("schedule_id"));
                schedule.setSyear(rs.getString("syear"));
                schedule.setSemester(rs.getString("semester"));
                schedule.setCollegeCode(rs.getString("college_code"));
                schedule.setBlockNo(rs.getString("block_no"));
                schedule.setSubjectCode(rs.getString("subject_code"));
                schedule.setDay(rs.getString("day"));
                schedule.setTime(rs.getString("time"));
                schedule.setRoom(rs.getString("room"));
                schedule.setType(rs.getString("type"));
                schedule.setSequenceNo(rs.getInt("sequence_no"));
                schedule.setEmployeeId(rs.getString("employee_id"));
                schedules.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedules;
    }


        public static List<Grades> readGrades() {
        List<Grades> gradesList = new ArrayList<>();
        String query = "SELECT * FROM Grades";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Grades grade = new Grades();
                grade.setGradeId(rs.getInt("grade_id"));
                grade.setSyear(rs.getString("syear"));
                grade.setSemester(rs.getString("semester"));
                grade.setStudentNo(rs.getInt("student_no"));
                grade.setSubjectCode(rs.getString("subject_code"));
                grade.setBlockNo(rs.getString("block_no"));
                grade.setGrade(rs.getDouble("grade"));
                gradesList.add(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gradesList;
    }
}
