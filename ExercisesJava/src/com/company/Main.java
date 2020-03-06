package com.company;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
      Anonymous();

    }
    public static void Anonymous (){
        Scanner sc = new Scanner(System.in);
        List<String>  words = Arrays.stream(sc.nextLine().split(" ")).collect(Collectors.toList());
        String input = sc.nextLine();

        while (!input.equals("3:1")){

            String [] commands = input.split(" ");
            if (commands[0].equals("merge")){

                int startIndex = Integer.parseInt(commands[1]);
                int endIndex = Integer.parseInt(commands[2]);
                words = merger(startIndex,endIndex,words);

            }
            else if (commands[0].equals("divide")){
                int index = Integer.parseInt(commands[1]);
                int partitions = Integer.parseInt(commands[2]);
                words = divider(index,partitions,words);
            }

            input = sc.nextLine();
        }
        String result = words.toString()
                .replace(",","")
                .replace("[","")
                .replace("]","");
        System.out.println(String.join(" ",result));

    }
    public static List<String> divider(int index,int partitions, List<String> words){
        List<String> newList = words;
        String word = newList.get(index);
        newList.remove(index );
        int wordCount = (word.length()/partitions);
        String currWord = "";
        int oldIndex =0;
        int newIndex=wordCount;
        StringBuilder w = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            w.append((word.charAt(i)));
        }
        for (int i = 0; i < partitions; i++) {

            if(i==partitions-1){
                currWord = w.toString();
            }
            else   {
                currWord = w.substring(oldIndex,newIndex);
                w.replace(oldIndex,newIndex,"");
            }
            words.add(index+i,currWord);

        }

        return words;
    }


        public static List<String> merger(int startIndex,int endIndex, List<String> words){
        List<String> newWords  = words;
        if (endIndex>=words.size()){
            endIndex= words.size()-1;
        }
        if (startIndex<0){
            startIndex =0;
        }
        if(startIndex<endIndex){
            int count = startIndex;
            String newWord = words.get(startIndex);
            newWords.remove(startIndex);
            while (endIndex>count){
                String curWord = newWords.get(startIndex);
                newWord = newWord.concat(curWord);
                newWords.remove(startIndex);
                count++;
            }
            newWords.add(startIndex,newWord);
        }

        return   newWords;
    }
    public static  void AppendArrays(){
        Scanner sc = new Scanner(System.in);
        String [] input = sc.nextLine().split(Pattern.quote("|"));
        List<Integer> list = new ArrayList<>();

        for (int arr = input.length-1; arr >=0 ; arr--) {
            int[] array = Arrays.stream(input[arr].trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int value : array) {
                list.add(value);
            }
        }
        System.out.println(String.join(" ",list.toString()));
    }

    public static void ListOperations(){
        Scanner sc= new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        String input = sc.nextLine();
        numbers.stream().mapToInt(Integer::intValue).sum();


        while (!input.toLowerCase().equals("end")){
            String [] arrayInput = input.split(" ");
            switch (arrayInput[0].toLowerCase()) {
                case "add":
                    int numberToAdd = Integer.parseInt(arrayInput[1]);
                    numbers.add(numberToAdd);
                    break;
                case "remove": {
                    int index = Integer.parseInt(arrayInput[1]);
                    numbers.remove(index);
                    break;
                }
                case "insert": {
                    int number = Integer.parseInt(arrayInput[1]);
                    int index = Integer.parseInt(arrayInput[2]);
                    numbers.add(index, number);
                    break;
                }
                case "shift":
                    if (arrayInput[1].equals("left")) {
                        numbers = MoveLeftArray(numbers, Integer.parseInt(arrayInput[2]));
                    } else if (arrayInput[1].equals("right")) {
                        numbers = MoveRightArray(numbers, Integer.parseInt(arrayInput[2]));

                    }
                    break;
            }
            input= sc.nextLine();
        }
        System.out.println(String.join(" ",numbers.toString()));


    }
    public static List<Integer> MoveLeftArray(List<Integer> numbers,int moveLeftCount){
        List<Integer> newNumbers = numbers;

        for (int i = 0; i < moveLeftCount; i++) {
            newNumbers.add(newNumbers.get(0));
            newNumbers.remove(0);
        }
        return  newNumbers;
    }
    public static List<Integer> MoveRightArray(List<Integer> numbers,int moveRightCount){
        List<Integer> newNumbers = numbers;
        for (int i = 0; i < moveRightCount; i++) {
            int length = newNumbers.size();
            newNumbers.add(0,newNumbers.get(length-1));
            int newLength = newNumbers.size();
            newNumbers.remove(newLength-1);

        }
        return  newNumbers;
    }
    public static void exerciseLists(){
        Scanner sc = new Scanner(System.in);
        List<Integer> list = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        String inp = sc.nextLine();
        while (!inp.toLowerCase().equals("end")){

            String [] arrayInput = inp.split(" ");
            if (arrayInput[0].toLowerCase().equals("insert")){

                int number =Integer.parseInt(arrayInput[1]);
                int index = Integer.parseInt(arrayInput[2]);
                list.add(index,number);

            }
            else if (arrayInput[0].toLowerCase().equals("delete")){

                list = RemoveValueFromList(list,Integer.parseInt( arrayInput[1]));
            }
            inp = sc.nextLine();
        }
        System.out.println(String.join(" ",list.toString()));
    }
    public static List<Integer>  RemoveValueFromList(List<Integer> list, int valueToRemove){
        while (list.contains(valueToRemove)){
            list.remove(Integer.valueOf(valueToRemove));
        }
        return list;
    }
    public static void Train(){
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(sc.nextLine());
        int countPassengerNewTrain=0;
        String input = sc.nextLine();

        while (!input.toLowerCase().equals("end")){

            String [] arrayInput = input.split(" ");
            if (arrayInput[0].startsWith("Add")){
                countPassengerNewTrain = Integer.parseInt(arrayInput[1]);
                numbers.add(countPassengerNewTrain);
            }
            else{
                countPassengerNewTrain = Integer.parseInt(arrayInput[0]);
                for (int i = 0; i < numbers.size(); i++) {
                    int possiblePassengersIn = numbers.get(i) + countPassengerNewTrain;
                    if (possiblePassengersIn <= maxCapacity){
                        numbers.set(i, possiblePassengersIn);
                        break;
                    }
                }

            }

            input = sc.nextLine();
        }

        System.out.println(String.join(" ",numbers.toString() ));

    }
    public static void SumSidesArray(){
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(x->Integer.parseInt(x)).toArray();
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(i>j){
                    leftSum+=array[j];
                }
                if(i<j){
                    rightSum+=array[j];

                }
            }
            if (leftSum == rightSum || array.length==1){
                System.out.println(i);
            }
            leftSum=0;
            rightSum=0;
        }
    }
    public static void MoveElementsInArray(){
        Scanner sc = new Scanner(System.in);
        int[] oldArray = Arrays.stream(sc.nextLine().split(" ")).mapToInt(x-> Integer.parseInt(x)).toArray();
        int toLeft = Integer.parseInt(sc.nextLine());
        int[] newArray = new int[oldArray.length];
        int counter = 0;

        for (int i = 0; i < oldArray.length; i++) {
            if (toLeft%oldArray.length==0)
            {
                newArray = oldArray;
                break;
            }
            else if (oldArray.length < toLeft){
                toLeft -= oldArray.length -1;
            }
            if (oldArray.length  > oldArray.length-toLeft -1 + i){
                newArray[i] = oldArray[oldArray.length-toLeft -1 + i];
            }
            else {
                newArray[i] = oldArray[counter];
                counter++;
            }
        }
        ReadIntArray(oldArray);
        ReadIntArray(newArray);

    }

    public static void ZigZagArray(){
        Scanner sc = new Scanner(System.in);
        int length = Integer.parseInt(sc.nextLine());
        int[] firstArray = new int[length];
        int[] secondArray = new int[length];

        int counter = 1;
        for (int i = 0; i < length; i++) {
            int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (i%2==0){
                firstArray[i] = input[0];
                secondArray[i] = input[1];
            }
            else{
                firstArray[i] = input[1];
                secondArray[i] = input[0];
            }
        }
        ReadIntArray(firstArray);
        ReadIntArray(secondArray);


    }
    public static  void TestArrays(){
        Scanner sc =  new Scanner(System.in);
        int length = Integer.parseInt(sc.nextLine());

        int [] numbers = new int[length];

        for (int i = 0; i < numbers.length; i++) {
            int number = Integer.parseInt(sc.nextLine());
            numbers[i] = number;
        }
        ReadIntArray(numbers);

    }
    public static void ReadIntArray(int[] array){
        for (int i = 0; i < array.length ; i++) {
            System.out.print(array[i]+ " " );
        }
        System.out.println();
    }
    public static String[]  ReverseArray(){
        Scanner sc = new Scanner(System.in);
        String[] elements = sc.nextLine().split(" ");

        for (int i = 0; i < elements.length / 2; i++) {
            String oldElement = elements[i];
            elements[i] = elements[elements.length - 1 - i];
            elements[elements.length - 1 - i] = oldElement;

        }
        return elements;

    }
    public static void Login()
    {

        int count = 1;

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder passwordNew = new StringBuilder();
        for (int i = input.length(); i > 0 ; i--) {
            passwordNew.append(input.charAt(i-1));
        }
        String  curPassword = passwordNew.toString();
        while (true)
        {
            input = scanner.nextLine();

            if (input.equals(curPassword)){
                System.out.println("success");
                break;
            }
            else{
                System.out.println("wrong password");
            }

            count++;
            if (count >4){
                System.out.println("User is blocked");
                break;
            }
        }
    }

    public static void BeBackIn30Minutes(){
        String [] a = "01 40 50".split(" ");
        int [] arr = Arrays.stream(a).mapToInt(Integer::parseInt).toArray();
        int hours =  arr[0];
        int minutes =  arr[1];
        int addedMinutes =  arr[2];
        int addHours = (minutes + addedMinutes)/60;
        int newHours = hours + addHours;
        int newMinutes = (minutes+addedMinutes)%60;
        System.out.printf("%d:%02d%n",newHours,newMinutes);
    }
    public static void Division()
    {
        int number = 15;
        int[] divisionNumber = new int[]{
                10,7,6,3,2
        };
        int result = 0;
        for (int i = 0; i < divisionNumber.length; i++) {
           if (number%divisionNumber[i] == 0){
               result = divisionNumber[i];
               break;
           }
        }
        System.out.println("The number is divided by " + result);
    }



    public static void stringCall(String a)
    {
        Scanner g = new Scanner(System.in);
        System.out.println(a);
    }
    public static void switchTest()
    {
        Scanner sc = new Scanner(System.in);
        int number2 = Integer.parseInt(sc.nextLine());
        switch (number2) {
            case 9:
            case 4:
                System.out.println("yes"); break;
            case 100:
                System.out.println("no"); break;
            default:
                System.out.println("unknown");

        }
    }
    public static  void StringFormatTest(){
        String a = "sda";
        int number = 55;
        // System.out.printf("%d",number);

        String string = String.format("name: %s",a);
        System.out.println(string);
    }
    public static void LoopTest(){

        int number = 4;
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void RageQuit(){
        Scanner sc = new Scanner(System.in);
        int lostInRow = Integer.parseInt(sc.nextLine()) ;
        double headsetPrice = Double.parseDouble(sc.nextLine());
        double mousePrice = Double.parseDouble(sc.nextLine());;
        double keyboardPrice = Double.parseDouble(sc.nextLine());;
        double displayPrice = Double.parseDouble(sc.nextLine());;

        int throwHeadsets =0;
        int throwMouse =0;
        int throwKey =0;
        int throwDisplays =0;
        int currentKeyThrown = 0;
        boolean isThrowingHeadsets = false;
        boolean isThrowingMouse = false;

        for (int i = 1; i <=lostInRow; i++) {
            if (i%2==0){
                throwHeadsets++;
                isThrowingHeadsets = true;
            }
            if (i%3 == 0){
                throwMouse++;
                isThrowingMouse = true;
            }
            if (isThrowingMouse && isThrowingHeadsets){
                throwKey++;
                currentKeyThrown++;
            }
            if (currentKeyThrown%2 == 0 && currentKeyThrown>0){
                throwDisplays++;
                currentKeyThrown=0;
            }
            isThrowingHeadsets = false;
            isThrowingMouse = false;

        }
        double totalSpent = (throwDisplays*displayPrice + throwKey*keyboardPrice +throwMouse*mousePrice + throwHeadsets*headsetPrice);
        System.out.printf("Rage expenses: %.2f lv%n",totalSpent);
        System.out.printf("Trashed headsets: %d%n",throwHeadsets);
        System.out.printf("Trashed mouses: %d%n",throwMouse);
        System.out.printf("Trashed keyboards: %d%n",throwKey);
        System.out.printf("Trashed displays: %d%n",throwDisplays);


    }
}
