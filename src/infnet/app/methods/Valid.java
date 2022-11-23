package infnet.app.methods;

import java.util.Scanner;

public class Valid {

    static Scanner scanner = new Scanner(System.in);
    
    public static boolean data(String data, String input){
        boolean validData = false;
                    
        switch(data){
            case "Id":
                validData = isId(input);
                break;
            case "Name":
                validData = isName(input);
                break;
            case "Age":
                validData = isInt(input);
                break;
            case "Grade 1":
                validData = isGrade(input);
                break;    
            case "Grade 2":
                validData = isGrade(input);
                break;  
        }
        return validData;
    }

    private static boolean isId(String input) {
        boolean validId = false;

        if (isInt(input)){
            int id = Integer.parseInt(input);

            if (id >= 0 && id <= 100){
                validId = true;
            }
        }

        return validId;
    }

    private static boolean isName(String input){
        boolean isName = false;

        char[] chars = input.toCharArray();
        StringBuilder intList = new StringBuilder();
        for(char c : chars){
            if(Character.isDigit(c)){
                intList.append(c);
            }
        }

        if (intList.length() == 0){
            isName = true;
        }

        return isName;
    }

    private static boolean isGrade(String input){
        boolean validGrade = false;

        if(isFloat(input)){
            Float grade = Float.parseFloat(input);

            if (grade >= 0 && grade <= 10){
                validGrade = true;
            }
        }

        if (!validGrade){
            Print.message("The grade must be greater than 0 and less than 10.");
        }

        return validGrade;
    }

    private static boolean isInt(String input){
        boolean isInt = false;

        try{
            Integer.parseInt(input);
            isInt = true;
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }

        return isInt;
    }

    private static boolean isFloat(String input){
        boolean isFloat = false;

        try{
            Float.parseFloat(input);
            isFloat = true;
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }

        return isFloat;
    } 
}