package Student;

public class Undergraduate extends Student {
    public Undergraduate(String name) {
        super(name);
    }

    @Override
    public void printStudentDetails() {
        System.out.println("Undergraduate Student: " + name);
        for (Course course : courses) {
            System.out.println("Enrolled in: " + course.getName());
        }
    }
}
