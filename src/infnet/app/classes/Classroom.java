package infnet.app.classes;

public class Classroom {

    public final static int MAX_CLASS = 100;
    public static int nextStudentId = 0;

    private static Student[] studentsList = new Student[MAX_CLASS];

    private static String[] namesList = new String[MAX_CLASS];
    private static String[] statusList = new String[MAX_CLASS];
    private static Float[] finalGradeList = new Float[MAX_CLASS];  

    public static Student[] getStudentsList(){
        return studentsList;
    }

    public static void addStudent(Student student){
        
        student.setId(nextStudentId);
        
        studentsList[nextStudentId] = student;
        namesList[nextStudentId] = student.getName();
        finalGradeList[nextStudentId] = student.getGradeFinal();
        statusList[nextStudentId] = student.getStatus();
        
        nextStudentId++;
    };

    public static Student getStudentById(int inputId){
        Student studentFound = null;

        for (Student student : studentsList) {
            if (student != null){
                if(student.getId() == inputId){
                    studentFound = studentsList[inputId];
                }
            }
        }
        return studentFound;
    };

    public static Student getStudentByName(String inputName){
        Student studentFound = null;

        for (Student student : studentsList) {
            if (student != null){
                if(student.getName().equalsIgnoreCase(inputName)){
                    studentFound = studentsList[student.getId()];
                }
            }
        }
        return studentFound;
    };

    public static String[] getStudentsNames(){
        return namesList;
    }
    public static Float[] getStudentsFinalGrades(){
        return finalGradeList;
    }
    public static String[] getStudentsStatus(){
        return statusList;
    }
}
