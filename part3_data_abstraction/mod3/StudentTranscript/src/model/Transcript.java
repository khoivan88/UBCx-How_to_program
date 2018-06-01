package model;

import java.util.ArrayList;
import java.util.List;

/**
 * INVARIANT: course list and grade list are the same size
 * each course has a grade associated, and vice versa, at matching indices
 */
public class Transcript {
    private String studentName;
    private int studentID;
    private ArrayList<String> courses;
    private ArrayList<Double> grades;

    public Transcript(String studentName, int studentID) {
        this.studentName = studentName;
        this.studentID = studentID;
        courses = new ArrayList<String>();
        grades = new ArrayList<Double>();
    }

    // getters
    public String getStudentName() {
        return this.studentName;
    }

    public int getStudentID() {
        return this.studentID;
    }

    // setters
    public void setStudentName(String newName) {
        this.studentName = newName;
    }

    public void setStudentID(int newStudentID) {
        this.studentID = newStudentID;
    }

    //REQUIRES: the grade should be between 0.0 and 4.0, and/or the course should not be null
    //MODIFIES: this
    //EFFECTS: add grade into course;
    //         if course does not exist, create course and then add grade
    public void addGrade(String course, double grade){
        courses.add(course);
        grades.add(grade);
    }

    //REQUIRES: a course the student has already taken.
    //EFFECTS: returns course name and grade in format CourseName: Grade
    public String getCourseAndGrade(String course){
        int index = courses.indexOf(course);
        return course + ": " + grades.get(index);
    }

    //REQUIRES: TODO
    //EFFECTS: print model.Transcript to screen
    public void printTranscript(){
        System.out.print(getStudentName()+": ");
        for (String course: courses) {
            System.out.print(getCourseAndGrade(course) + ", ");
        }
        System.out.println();
        System.out.println("GPA: " + getGPA());
    }

    //EFFECTS: return GPA of student of interest
    public double getGPA(){
//        return grades.stream().mapToDouble(i -> i).average().getAsDouble();
        return calculateAverage(grades);
    }

    /**
     * calculate the average of a list of grades
     * @param selectedGrades, a list of grades
     * @return the average
     */
    private double calculateAverage(List<Double> selectedGrades){
        double sum = 0;
        for (Double grade: selectedGrades) {
            sum += grade;
        }
        return sum/selectedGrades.size();
    }

    /**
     * return the grade for the given course parameter
     * @param String course: the name of the course, must exists in the courses list.
     * @return double the grade of the student for that course
      */
    private double getGradeByCourse(String course){
        int index = courses.indexOf(course);
        return grades.get(index);
    }

    /**
     * return average GPA of the courses in selectedCourses list
     * @param selectedCourses, courses in selectedCourses must exist in the courses
     *                         taken by this student
     * @return GPA of the courses in the selectedCourses
     */
    public double getAverageOverSelectedCourses(List<String> selectedCourses){
        ArrayList<Double> newGrades = new ArrayList<Double>();
        for (String course: selectedCourses) {
            newGrades.add(getGradeByCourse(course));
        }
        return calculateAverage(newGrades);
    }
}
