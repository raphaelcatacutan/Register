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
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                SchoolYear sy = new SchoolYear();
                sy.setSyear(rs.getString("syear"));
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
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Semester semester = new Semester();
                semester.setSemester(rs.getString("semester"));
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
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
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
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
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
        String query = "SELECT * FROM Student";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Student student = new Student();
                student.setStudentNo(rs.getInt("student_no"));
                student.setLastname(rs.getString("lastname"));
                student.setFirstname(rs.getString("firstname"));
                student.setEmail(rs.getString("email"));
                student.setGender(rs.getString("gender"));
                student.setCourseCode(rs.getString("course_code"));
                student.setCpNum(rs.getLong("cp_num"));
                student.setAddress(rs.getString("address"));
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
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
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
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
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
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
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
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
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

    public static SchoolYear readSchoolYearByYear(String year) {
        SchoolYear schoolYear = null;
        String query = "SELECT * FROM SchoolYear WHERE year = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, year);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    schoolYear = new SchoolYear();
                    schoolYear.setSyear(rs.getString("year"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schoolYear;
    }

    public static Semester readSemesterByName(String name) {
        Semester semester = null;
        String query = "SELECT * FROM Semester WHERE name = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    semester = new Semester();
                    semester.setSemester(rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return semester;
    }

    public static College readCollegeByCode(String collegeCode) {
        College college = null;
        String query = "SELECT * FROM College WHERE college_code = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, collegeCode);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    college = new College();
                    college.setCollegeCode(rs.getString("college_code"));
                    college.setDescription(rs.getString("description"));
                    college.setDateOpened(rs.getDate("date_opened"));
                    college.setDateClosed(rs.getDate("date_closed"));
                    college.setStatus(rs.getString("status"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return college;
    }

    public static Course readCourseByCode(String courseCode) {
        Course course = null;
        String query = "SELECT * FROM Course WHERE course_code = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, courseCode);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    course = new Course();
                    course.setCourseCode(rs.getString("course_code"));
                    course.setDescription(rs.getString("description"));
                    course.setCollegeCode(rs.getString("college_code"));
                    course.setDateOpened(rs.getDate("date_opened"));
                    course.setDateClosed(rs.getDate("date_closed"));
                    course.setStatus(rs.getString("status"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }

    public static Student readStudentById(int studentNo) {
        Student student = null;
        String query = "SELECT * FROM Student WHERE student_no = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, studentNo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    student = new Student();
                    student.setStudentNo(rs.getInt("student_no"));
                    student.setLastname(rs.getString("lastname"));
                    student.setFirstname(rs.getString("firstname"));
                    student.setEmail(rs.getString("email"));
                    student.setGender(rs.getString("gender"));
                    student.setCourseCode(rs.getString("course_code"));
                    student.setCpNum(rs.getLong("cp_num"));
                    student.setAddress(rs.getString("address"));
                    student.setBday(rs.getDate("bday"));
                    student.setStatus(rs.getString("status"));
                    student.setDateStarted(rs.getDate("date_started"));
                    student.setDateGraduated(rs.getDate("date_graduated"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public static Employee readEmployeeById(String employeeId) {
        Employee employee = null;
        String query = "SELECT * FROM Employee WHERE employee_id = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, employeeId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    employee = new Employee();
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
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    public static Subject readSubjectByCode(String subjectCode) {
        Subject subject = null;
        String query = "SELECT * FROM Subject WHERE subject_code = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, subjectCode);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    subject = new Subject();
                    subject.setSubjectCode(rs.getString("subject_code"));
                    subject.setDescription(rs.getString("description"));
                    subject.setUnits(rs.getInt("units"));
                    subject.setCurriculum(rs.getString("curriculum"));
                    subject.setCollegeCode(rs.getString("college_code"));
                    subject.setStatus(rs.getString("status"));
                    subject.setDateOpened(rs.getDate("date_opened"));
                    subject.setDateClosed(rs.getDate("date_closed"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subject;
    }

    public static Schedule readScheduleById(int scheduleId) {
        Schedule schedule = null;
        String query = "SELECT * FROM Schedule WHERE schedule_id = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, scheduleId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    schedule = new Schedule();
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
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedule;
    }

    public static Grades readGradeById(int gradeId) {
        Grades grade = null;
        String query = "SELECT * FROM Grades WHERE grade_id = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, gradeId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    grade = new Grades();
                    grade.setGradeId(rs.getInt("grade_id"));
                    grade.setSyear(rs.getString("syear"));
                    grade.setSemester(rs.getString("semester"));
                    grade.setStudentNo(rs.getInt("student_no"));
                    grade.setSubjectCode(rs.getString("subject_code"));
                    grade.setBlockNo(rs.getString("block_no"));
                    grade.setGrade(rs.getDouble("grade"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grade;
    }

    public static void main(String[] args) {
        List<Student> students = DBReadMd.readStudents();

        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
}
