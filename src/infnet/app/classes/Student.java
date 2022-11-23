package infnet.app.classes;

public class Student {

    private static int id;
    private static String firstName;
    private static String middleName = "";
    private static String lastName = "";
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

    private void setFirstName(String inputFirstName) {
        firstName = inputFirstName;
    };

    private String getFirstName(){
        return firstName;
    };

    private void setMiddleName(String inputMiddleName) {
        middleName = inputMiddleName;
    };

    private String getMiddleName(){
        return middleName;
    };

    private void setLastName(String inputLastName) {
        lastName = inputLastName;
    };

    private String getLastName(){
        return lastName;
    };

    public void setName(String inputFullName) {
        String[] nameArray = inputFullName.split(" ");

        setFirstName(nameArray[0]);
        if(nameArray.length > 2){
            setMiddleName(middleNameBuilder(nameArray));
        }
        if(nameArray.length > 1){
            setLastName(nameArray[nameArray.length -1]);
        }
        
    };

    public String getName(){
        StringBuilder fullName = new StringBuilder();

        String firstName = getFirstName();
        String middleName = getMiddleName();
        String lastName = getLastName();

        fullName.append(firstName);
        fullName.append(" ");
        fullName.append(middleName);
        fullName.append(" ");
        fullName.append(lastName);

        return fullName.toString();
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

    private String middleNameBuilder(String[] nameArray){
        StringBuilder middleNameBuilder = new StringBuilder();

        for (int i = 1; i < nameArray.length -1; i++) {
            middleNameBuilder.append(nameArray[i]);
            if(i < nameArray.length -2){
                middleNameBuilder.append(" ");
            }
        }

        return middleNameBuilder.toString();
    }

    @Override
	public String toString() {
		return
        "--------------------------------\n" + 
        "ID: " + this.getId() + "\n" + 
        "Name: " + this.getName() + "\n" + 
        "Age: " + this.getAge() + "\n" + 
        "Grade 1: " + this.getGrade1() + "\n" + 
        "Grade 2: " + this.getGrade2() + "\n" + 
        "Final Grade 1: " + this.getGradeFinal() + "\n" + 
        "Student Status: " + this.getStatus() + "\n" + 
        "--------------------------------";
	}
}