import java.util.*;
import java.io.*;

class Student {
    int id;
    String name;
    String email;
    Student(int id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public String toString(){
        return id + " | " + name + " | " + email;
    }
}

class Course {
    int id;
    String title;
    String desc;
    Course(int id, String title, String desc){
        this.id = id;
        this.title = title;
        this.desc = desc;
    }
    public String toString(){
        return id + " | " + title + " | " + desc;
    }
}

class Enrollment {
    int id;
    int studentId;
    int courseId;
    Enrollment(int id, int sid, int cid){
        this.id = id;
        this.studentId = sid;
        this.courseId = cid;
    }
    public String toString(){
        return id + " | student=" + studentId + " | course=" + courseId;
    }
}

public class Main {

    static List<Student> students = new ArrayList<>();
    static List<Course> courses = new ArrayList<>();
    static List<Enrollment> enrollments = new ArrayList<>();

    static int studentCounter = 1;
    static int courseCounter = 1;
    static int enrollCounter = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("===== Simple Java LMS (No Database) =====");

        while(true){
            System.out.println("\n1. Add Student");
            System.out.println("2. List Students");
            System.out.println("3. Add Course");
            System.out.println("4. List Courses");
            System.out.println("5. Enroll Student");
            System.out.println("6. List Enrollments");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            String choice = sc.nextLine();

            switch(choice){
                case "1": addStudent(sc); break;
                case "2": listStudents(); break;
                case "3": addCourse(sc); break;
                case "4": listCourses(); break;
                case "5": enroll(sc); break;
                case "6": listEnrollments(); break;
                case "0": 
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    static void addStudent(Scanner sc){
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();

        Student s = new Student(studentCounter++, name, email);
        students.add(s);

        System.out.println("Added: " + s);
    }

    static void listStudents(){
        if(students.isEmpty()) System.out.println("No students found");
        else students.forEach(System.out::println);
    }

    static void addCourse(Scanner sc){
        System.out.print("Enter course title: ");
        String title = sc.nextLine();
        System.out.print("Enter description: ");
        String desc = sc.nextLine();

        Course c = new Course(courseCounter++, title, desc);
        courses.add(c);

        System.out.println("Added: " + c);
    }

    static void listCourses(){
        if(courses.isEmpty()) System.out.println("No courses found");
        else courses.forEach(System.out::println);
    }

    static void enroll(Scanner sc){
        listStudents();
        System.out.print("Enter student id: ");
        int sid = Integer.parseInt(sc.nextLine());

        listCourses();
        System.out.print("Enter course id: ");
        int cid = Integer.parseInt(sc.nextLine());

        Enrollment e = new Enrollment(enrollCounter++, sid, cid);
        enrollments.add(e);

        System.out.println("Enrolled: " + e);
    }

    static void listEnrollments(){
        if(enrollments.isEmpty()) System.out.println("No enrollments");
        else enrollments.forEach(System.out::println);
    }
}
