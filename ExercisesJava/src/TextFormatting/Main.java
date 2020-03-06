package TextFormatting;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] usernames = sc.nextLine().split(", ");
        ValidateFormat users = new ValidateFormat();
        String validNames=  users.getValidNames(usernames);
        System.out.println(validNames);


    }
}
