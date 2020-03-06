package Letters_Change_Numbers;

import java.util.Scanner;

public class MainLetter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] input = sc.nextLine().split(" ");
        double sum  = 0;
        for (int i = 0; i < input.length; i++) {
            sum+= getSingleSum(input[i].trim());
        }
        System.out.printf("%.2f%n",sum);
    }

    private static double getSingleSum(String line) {
        double sum = 0;
        char firstLetter = line.charAt(0);
        char secondLetter = line.charAt(line.length()-1);
        double number = Double.parseDouble( line.substring(1,line.length()-1));
        int positionOfLetter=  getLetterPosition(firstLetter);
        int positionOfLetter2 = getLetterPosition(secondLetter);
        if (isUpper(firstLetter)){
            sum += number/positionOfLetter;
        }
        else  {
            sum += number*positionOfLetter;
        }
        if (isUpper(secondLetter)){

            sum -=positionOfLetter2;
        }
        else {
            sum +=positionOfLetter2;

        }
        return sum;
    }

    public  static boolean isUpper(char letter){

        String curLetter = String.valueOf(letter);
        boolean isUpper = curLetter.equals(curLetter.toUpperCase());
        return isUpper;

    }

    public static int getLetterPosition(Character letter){

        int letterPosition = 0;
        int tempLetter = letter;
        int temp_integer;
        if(tempLetter<=122 & tempLetter>=97) {
                temp_integer = 96;
                letterPosition = tempLetter-temp_integer;
        }
        else if (tempLetter>=65 && tempLetter<=90){
                temp_integer = 64;
                letterPosition = tempLetter-temp_integer;
        }

        return letterPosition;
    }
}
