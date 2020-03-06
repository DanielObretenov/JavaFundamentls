package CountChars;

import jdk.nashorn.internal.ir.CaseNode;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        MapGame();
    }
    public static void MapGame(){

        Scanner sc = new Scanner(System.in);
        int counter = 0;
        Map<String,Integer> items= new HashMap<>();
        String [] itemInput = sc.nextLine().split(" ");
        Map<String,Integer> valuedItems= new HashMap<>();


        List<String> valuableItems = Arrays.asList("shards", "fragments", "motes");

        while (true){
            if (counter/2 > (itemInput.length)/2-1){
                itemInput = sc.nextLine().split(" ");
                counter=0;
            }


                String name = itemInput[counter+1].toLowerCase();
                int newCount = Integer.parseInt( itemInput[counter]);
                if (items.containsKey(itemInput[counter+1])){
                    int currCount = items.get(name);
                    items.put(name,newCount+ currCount);

                }
                else{
                    items.put(name,newCount);
                }
                if (items.get(name)> 250 && valuableItems.contains(name)){
                    int currCount = items.get(name);
                    items.put(name, currCount - 250);
                    ItemGained(name);
                    break;

                }



            counter+=2;

        }

        for (Map.Entry<String,Integer> a: items.entrySet() ) {
            if (valuableItems.contains(a.getKey())){
                valuedItems.put(a.getKey(),a.getValue());
                items.remove(a.getKey());
            }
        }


    }

    public static void ItemGained(String item){
        String smallCaseItem = item.toLowerCase();
        switch (smallCaseItem){
            case "motes":
                System.out.println("You have obtained Dragonwrath");
                break;
            case "fragments":
                System.out.println("You have obtained Valanyr");
                break;
            case "shards":
                System.out.println("You have obtained Shadowmourne");
                break;


        }
    }
    public static void MapTest(){
        Scanner sc = new Scanner(System.in);
        int [] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, Integer> map= new TreeMap<>();

        for (int i = 0; i < array.length; i++) {

            if (map.containsKey(array[i])){
                Integer currentCount = map.get(array[i]);
                map.put(array[i], 1 + currentCount);
            }
            else {
                map.put(array[i],1);
            }
        }
        for (Map.Entry<Integer,Integer> a:
                map.entrySet()) {
            System.out.printf("%d : %d%n", a.getKey(),a.getValue());

        }
    }
}
