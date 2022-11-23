package infnet.app.methods;

import java.util.Scanner;

import infnet.app.classes.Student;
import infnet.app.classes.Classroom;

public class Menu {

    static String input;
    
    static Scanner scanner = new Scanner(System.in);

    public static void mainMenu(){
        do {
            Print.mainMenuOptions();
            
            input = scanner.nextLine();  
            
            switch (input) {
                case "1":
                    registerStudent();
                    break;
    
                case "2":
                    consultStudent();
                    break;  
                
                case "3":
                    listStudents();
                    break;
                case "4":
                    listStudentsNames();
                    break;
                case "5":
                    listStudentsFinalGrades();
                    break;
                case "6":
                    listStudentsStatus();
                    break;
                default:
                    break;
            }
            
        } while (!"0".equalsIgnoreCase(input));
    }

    private static void registerStudent() {

        if (Classroom.nextStudentId < Classroom.MAX_CLASS) {
            Student student = new Student();
        
            setData("Full Name", student);        
            setData("Age", student);
            setData("Grade 1", student);
            setData("Grade 2", student);

            Classroom.addStudent(student);

            int savedId = Classroom.nextStudentId -1;
            Student savedStudent = Classroom.getStudentsList()[savedId];

            Print.message("Student "+ savedStudent.getName() +" ---> saved with the ID "+ savedStudent.getId());
            Print.studentData(savedStudent);
        } else {
            Print.message("Classroom is already full, it is not possible to register new students.");
        }
        
    };

    private static void consultStudent() {
        do {
            Print.consultStudentOptions();

            input = scanner.next();

            switch (input) {
                case "1":
                    consultStudentBy("Name");
                    break;

                case "2":
                    consultStudentBy("Id");
                    break;  
            }

        } while (!"3".equalsIgnoreCase(input));
    };

    private static void listStudents() {
        Print.dataList(Classroom.getStudentsList());
    };

    private static void listStudentsNames() {
        Print.dataList(Classroom.getStudentsNames());
    }

    private static void listStudentsFinalGrades() {
        Print.dataList(Classroom.getStudentsFinalGrades());
    }

    private static void listStudentsStatus() {
        Print.dataList(Classroom.getStudentsStatus());
    }   

    private static void setData(String data, Student student){
        boolean validData = false;
        
        do {
            Print.message("Student " + data + ": ");
            input = scanner.nextLine();
            
            switch(data){
                case "Full Name":
                    validData = Valid.data("Name", input);
                    if (validData){
                        student.setName(input);
                    }
                    break;

                case "Age":
                    validData = Valid.data("Age", input);
                    if (validData){
                        student.setAge(Integer.parseInt(input));
                    }
                    break;

                case "Grade 1":
                    validData = Valid.data("Grade 1", input);
                    if (validData){
                        student.setGrade1(Float.parseFloat(input));
                    }
                    break;

                case "Grade 2":
                    validData = Valid.data("Grade 2", input);
                    if (validData){
                        student.setGrade2(Float.parseFloat(input));
                    }
                    break; 
            }

            if (!validData) {
                Print.message("Invalid student " + data + ", please try again.");
            }

        } while (!validData);

    };

    private static void consultStudentBy(String data) {
        boolean validData = false;
        Student studentFound = null;

        do {
            Print.message("Student " + data + ": ");
            input = scanner.next();

            switch(data){
                case "Name":
                    validData = Valid.data("Name", input);
                    if (validData){
                        studentFound = Classroom.getStudentByName(input);
                    }
                    break;
    
                case "Id":
                    validData = Valid.data("Id", input);
                    if (validData){
                        studentFound = Classroom.getStudentById(Integer.parseInt(input));
                    }
                    break;
            }

        if (!validData) {
                Print.message("Invalid student " + data + ", please try again.");
            }

        } while (!validData);
        
        if (studentFound != null){
            Print.studentData(studentFound);
        } else {
            Print.message("Student with the " + data + " "+ input + " NOT Found.");
        }
    }
}