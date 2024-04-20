package Student;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Ваше имя:");
        String name = scanner.nextLine();

        System.out.println("Вы студент или выпускница? (u/g):");
        String type = scanner.nextLine();
        Student student;

        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course("Mathematics", 70, 50, 60));
        courseList.add(new Course("Physics", 50, 70, 30));
        courseList.add(new Course("Science", 40, 40, 70));

        if ("u".equalsIgnoreCase(type)) {
            student = new Undergraduate(name);

            System.out.println("Available courses and their requirements:");
            for (Course course : courseList) {
                System.out.println(course.getName() + " - Math: " + course.getRequirements().get("math") +
                        ", Physics: " + course.getRequirements().get("physics") +
                        ", Science: " + course.getRequirements().get("science"));
            }

            System.out.println("\nВведите свой балл по математике:");
            int mathScore = scanner.nextInt();
            System.out.println("Введите свой балл по физике:");
            int physicsScore = scanner.nextInt();
            System.out.println("Введите свой балл по естественным наукам:");
            int scienceScore = scanner.nextInt();

            System.out.println("Выберите курс (введите номер): 1 - Mathematics, 2 - Physics, 3 - Science");
            int choice = scanner.nextInt() - 1;

            if (choice < 0 || choice >= courseList.size()) {
                System.out.println("Неверный выбор курса. Попробуйте снова.");
                return;
            }

            Course selectedCourse = courseList.get(choice);
            if (selectedCourse.isEligible(mathScore, physicsScore, scienceScore)) {
                System.out.println("Вы подходите для курса " + selectedCourse.getName() + ". Выберите степень: 1 - Student, 2 - Bachelor");
                int degree = scanner.nextInt();
                String degreeName = degree == 1 ? "Student" : "Bachelor";
                System.out.println("Вы успешно записаны на курс " + selectedCourse.getName() + " как " + degreeName + ".");
            } else {
                System.out.println("Ваши баллы не соответствуют требованиям для " + selectedCourse.getName() + ".");
                findAlternativeCourse(courseList, mathScore, physicsScore, scienceScore);
            }
        } else {
            student = new Graduate(name);
            // Случайный выбор курса и степени
            String[] courses = {"Mathematics", "Physics", "Science"};
            String[] degrees = {"Student", "Bachelor"};
            int courseIndex = random.nextInt(courses.length);
            int degreeIndex = random.nextInt(degrees.length);
            int randomMathScore = random.nextInt(101);
            int randomPhysicsScore = random.nextInt(101);
            int randomScienceScore = random.nextInt(101);

            System.out.println("Вы выпускник курса: " + courses[courseIndex]);
            System.out.println("Степень: " + degrees[degreeIndex]);
            System.out.println("Ваши баллы по окончанию учебы: Математика: " + randomMathScore + ", Физика: " + randomPhysicsScore + ", Естественные науки: " + randomScienceScore);
        }

        scanner.close();
    }

    private static void findAlternativeCourse(List<Course> courses, int mathScore, int physicsScore, int scienceScore) {
        boolean found = false;
        for (Course course : courses) {
            if (course.isEligible(mathScore, physicsScore, scienceScore)) {
                System.out.println("Вы подходите для курса " + course.getName() + ". Хотите записаться на этот курс? (yes/no)");
                Scanner scanner = new Scanner(System.in);
                String response = scanner.next();
                if ("yes".equalsIgnoreCase(response)) {
                    System.out.println("Вы успешно записаны на курс " + course.getName() + ".");
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("Нет подходящих курсов по вашим баллам.");
        }
    }
}
