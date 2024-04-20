package Student;

public class Graduate extends Student {
    public Graduate(String name) {
        super(name);
    }

    @Override
    public void printStudentDetails() {
        System.out.println("Graduate Student: " + name);
        for (Course course : courses) {
            System.out.println("Enrolled in: " + course.getName());
        }
    }
}
