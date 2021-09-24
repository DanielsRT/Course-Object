import java.util.*;
import java.io.*;

public class CourseClient {
    public static void main(String[] args) {
        System.out.println("Welcome to the CourseClient");
        TestCourseObject();
        
        if (args.length == 1) {
            System.out.println("Please enter a target discipline after filename");
            System.exit(0);
        } else if (args.length < 1) {
            System.out.println("Please add filename and target discipline");
            System.exit(0);
        }
        String targetDiscipline = args[1];
        String filename = args[0];
        File input_file = new File(filename);
        ArrayList<Course> courses = new ArrayList<>();
        try (Scanner file_scanner = new Scanner(input_file)) {
            // file opened correctly, so proceed to read it
            while (file_scanner.hasNext()) {
                String name = file_scanner.nextLine();
                String discipline = file_scanner.nextLine();
                String number = file_scanner.nextLine();
                int hours = Integer.parseInt(file_scanner.nextLine());

                Course c = new Course(name,discipline,number,hours);
                courses.add(c);  
            }
        } catch (Exception e) {
            System.out.println("\nFile '" + filename + "' couldn't be opened. Program stopping.");
            System.exit(0);
        }
        
        System.out.println("\nThere are " + courses.size() + " courses in '" + filename + "':");
        for (Course c : courses) {
            System.out.println("  " + c);
        }
        
        int totalHours = getTotalHours(courses);
        System.out.println("Total credit hours: " + totalHours);
        
        displayTargetCourses(courses,targetDiscipline);
    }//main
    
    // displayTargetCourses(courses,targetDiscipline);
    public static void displayTargetCourses(ArrayList<Course> courses, String targetDiscipline) {
        System.out.println("\n'" + targetDiscipline + "' courses:");
        int totalHours = 0;
        for (int ndx = 0; ndx < courses.size(); ndx++) {
            Course currentCourse = courses.get(ndx);
            int hours = currentCourse.getHours();
            String discipline = currentCourse.getDiscipline();
            if (discipline.equals(targetDiscipline)) {
                totalHours += hours;
                System.out.println("  " + currentCourse);
            } 
        }
        System.out.println("Total credit hours: " + totalHours);
    }
    
    // int totalHours = getTotalHours(courses);
    public static int getTotalHours(ArrayList<Course> courses) {
        int totalHours = 0;
        for (int ndx = 0; ndx < courses.size(); ndx++) {
            Course currentCourse = courses.get(ndx);
            int hours = currentCourse.getHours();
            totalHours += hours;
        }
        return totalHours;
    }
    
    public static void TestCourseObject() {
        //default
        Course my_course = new Course();
        //parameterized
        Course another_course = new Course("Logic","PHIL","2040",3);
        System.out.println(my_course);
        System.out.println(another_course);
        
        System.out.println("\nName of another_course: " + 
                           another_course.getCrseName());
        System.out.println("Discipline of another_course: " + 
                           another_course.getDiscipline());
        System.out.println("Course Number of another_course: " + 
                           another_course.getCrseNumber());
        System.out.println("another_course hours: " + 
                           another_course.getHours());
        
        Scanner keyb = new Scanner(System.in);
        
        System.out.print("\nEnter a new course number: ");
        String new_number = keyb.nextLine();
        another_course.setCrseNumber(new_number);
        System.out.println(another_course);
        
        System.out.print("Enter a new number of hours: ");
        int new_hours = Integer.parseInt(keyb.nextLine());
        another_course.setHours(new_hours);
        System.out.println(another_course);
    }
}//class