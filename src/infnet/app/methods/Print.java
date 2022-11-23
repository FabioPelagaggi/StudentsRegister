package infnet.app.methods;

import infnet.app.classes.Student;

public class Print {

    public static void message (String string){
        System.out.println();
        System.out.println(string);
    };

    public static void mainMenuOptions(){
        System.out.println("----------------- Main Menu -----------------");
        message("Choose one of the follow options:");
        message("[1] - Register a new Student");
        message("[2] - Consult one of the students");
        message("[3] - List all students");
        message("[4] - List all students names");
        message("[5] - List all students final grades");
        message("[6] - List all students status");

        message("[0] - Exit");
        System.out.println();
    };

    public static void consultStudentOptions(){
        System.out.println("----------------- Consult Student -----------------");
        message("Do you want to consult students by name or ID?");
        message("[1] - Name");
        message("[2] - ID");
        message("[3] - Back to Main Menu");
        System.out.println();
    }

    public static void studentData(Student student){
        System.out.println(student.toString());
        // System.out.println();
        // System.out.println("--------------------------------");
        // System.out.println("ID: " + student.getId());
        // System.out.println("Name: " + student.getName());
        // System.out.println("Age: " + student.getAge());
        // System.out.println("Grade 1: " + student.getGrade1());
        // System.out.println("Grade 2: " + student.getGrade2());
        // System.out.println("Final Grade 1: " + student.getGradeFinal());
        // System.out.println("Student Status: " + student.getStatus());
        // System.out.println("--------------------------------");
        // System.out.println();
    };

    // public static void listStudents(Student[] students){
    //     boolean found = false;

    //     for (Student student : students) {
    //         if(student != null){
    //             studentData(student);
    //             found = true;
    //         }
    //     }

    //     if (!found){
    //         message("There are no registered students in the classroom yet.");
    //     }
    // };

    public static void dataList(String[] dataList){
        boolean found = false;

        for (String data : dataList) {
            if (data != null) {
                message(data);
                found = true;
            }
        }

        if (!found){
            message("There are no registered students in the classroom yet.");
        }
    }
    public static void dataList(Float[] dataList){
        boolean found = false;

        for (Float data : dataList) {
            if (data != null) {
                message(data.toString());
                found = true;
            }
        }

        if (!found){
            message("There are no registered students in the classroom yet.");
        }
    }
    public static void dataList(Student[] dataList){
        boolean found = false;

        for (Student data : dataList) {
            if (data != null) {
                studentData(data);
                found = true;
            }
        }

        if (!found){
            message("There are no registered students in the classroom yet.");
        }
    }
}