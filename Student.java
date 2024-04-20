package Student;

import java.util.ArrayList;
import java.util.List;

public abstract class Student {
    protected String name;
    protected List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public abstract void printStudentDetails();

    public String getName() {
        return name;
    }
}
