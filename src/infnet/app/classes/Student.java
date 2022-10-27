package infnet.app.classes;

public class Student {

    private static int id;
    private static String name;
	private static int age;
	private static float grade1;
    private static float grade2;
    private static float gradeFinal;
    private static String status;

    public void setId(int inputId) {
        id = inputId;
    };
    public int getId(){
        return id;
    };

    public void setName(String inputName) {
        name = inputName;
    };
    public String getName(){
        return name;
    };

    public void setAge(int inputAge) {
        age = inputAge;
    };
    public int getAge(){
        return age;
    };

    public void setGrade1(float inputGrade1) {
        grade1 = inputGrade1;
    };
    public float getGrade1() {
        return grade1;
    };

    public void setGrade2(float inputGrade2) {
        grade2 = inputGrade2;
    };
    public float getGrade2() {
        return grade2;
    };

    private void setGradeFinal(float grade1, float grade2) {
        gradeFinal = (grade1 + grade2)/2;
    };

    public float getGradeFinal() {
        setGradeFinal(grade1, grade2);

        return gradeFinal;
    };

    private void setStatus(){
        setGradeFinal(grade1, grade2);

        if(gradeFinal < 4 ){
            status = "Failed";
        } else if (gradeFinal >= 4 && gradeFinal < 7){
            status = "Finals";
        } else if (gradeFinal >= 7){
            status = "Pass";
        } else {
            status = "Unknown, check if the grades are correct.";
        }
    }

    public String getStatus(){
        setStatus();

        return status;
    }
}