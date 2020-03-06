package padwan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class mainPadwan {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        String regexPattern ="(.+)?@(?<planet>(?<=@)[A-z]+).+(?<=:)(?<population>[\\d]+).*(?<type>[DA]).*(?<soldiers>(?<=->)[\\d]+)(.+)?";
        Pattern pattern = Pattern.compile(regexPattern);
        int messagesCount = Integer.parseInt( sc.nextLine());
        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        int countDestroyed = 0;
        int countAttacked =0;
        for (int i = 0; i < messagesCount; i++) {
            String messages = sc.nextLine();
            String curMessage =  decryptMessage(messages);
            Matcher matcher = pattern.matcher(curMessage);

            if(matcher.matches()){
                String planet = matcher.group("planet");
                String type = matcher.group("type");
                if(type.equals("A")){
                    countAttacked++;
                    attackedPlanets.add(planet);
                }else {
                    countDestroyed++;
                    destroyedPlanets.add(planet);
                }
           }

        }
        List<String> sortedDPlanets = destroyedPlanets
                .stream()
                .sorted(Comparator.comparing(String::toString))
                .collect(Collectors.toList());
        List<String> sortedAPlanets = attackedPlanets
                .stream()
                .sorted(Comparator.comparing(String::toString))
                .collect(Collectors.toList());
        System.out.printf("Attacked planets: %d%n",countAttacked);
        for (String p:sortedAPlanets) {
            System.out.println("-> "+ p);
        }
        System.out.printf("Destroyed planets: %d%n",countDestroyed);

        for (String p:sortedDPlanets) {
            System.out.println("-> "+ p);
        }


    }

    private static String  decryptMessage(String message) {
        Pattern pattern = Pattern.compile("[starSTAR]");
        Matcher matcher = pattern.matcher(message);
        int count = 0;
        while (matcher.find()){
            count++;
        }
        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            int currPosition = message.charAt(i);
            int newPosition = currPosition- count;
            char newChar =  (char)newPosition;
            decrypted.append(newChar);
        }
        return decrypted.toString();
    }
}
