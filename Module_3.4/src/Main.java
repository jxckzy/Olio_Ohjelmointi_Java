import java.io.*;

class Student implements Serializable {
    int id;
    String name;
    int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Student: " + name + " (id=" + id + ", age=" + age + ")";
    }
}


class Course implements Serializable {
    String courseCode;
    String courseName;
    String instructor;

    public Course(String courseCode, String courseName, String instructor) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public String toString() {
        return "Course: " + courseName + " (" + courseCode + "), taught by " + instructor;
    }
}


class Enrollment implements Serializable {
    Student student;
    Course course;
    String enrollmentDate;

    public Enrollment(Student student, Course course, String enrollmentDate) {
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
    }

    public String toString() {
        return student + "\n" + course + "\nEnrolled on: " + enrollmentDate;
    }
}


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student(1, "Alice Johnson", 21);
        Course course = new Course("JAVA101", "Introduction to Java", "Dr. Virtanen");
        Enrollment enrollment = new Enrollment(student, course, "2025-01-15");

        FileOutputStream fileOut = new FileOutputStream("enrollments.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(enrollment);
        out.close();
        System.out.println("Saved to enrollments.ser");

        FileInputStream fileIn = new FileInputStream("enrollments.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        Enrollment loadedEnrollment = (Enrollment) in.readObject();
        in.close();

        System.out.println("\nLoaded from file:");
        System.out.println(loadedEnrollment);
    }
}