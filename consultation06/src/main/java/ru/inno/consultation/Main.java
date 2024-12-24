package ru.inno.consultation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

//        List<Integer> intList = new ArrayList<>();
//        String[] strings;

//        try (BufferedReader reader = new BufferedReader(new FileReader("consultation06/src/main/resources/input.txt"))) {

//            String line = reader.readLine();
//
//            strings = line.split(",");
//
//            for (String s : strings) {
//                intList.add(Integer.parseInt(s));
//            }
//            System.out.println(intList);
//            intList.sort(Comparator.reverseOrder());
//            System.out.println(intList);
//
//            Integer[] newArray = intList.toArray(new Integer[0]);
//            System.out.println(Arrays.toString(newArray));
//
        Map<String, String> map = new HashMap<>();
        map.put("string", "string");
        map.put("int", "int");

        if (map.containsKey("string")) {
            String newString = (String) map.get("string") + ", string2";
            map.put("string", newString);
        }

        System.out.println(map.size());


        System.out.println(map.keySet());

        map.remove("int");

        System.out.println(map.toString());


//        System.out.println("Получение значения из мапы: " + map.getOrDefault("str", "123"));

//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        try (FileWriter fileWriter = new FileWriter("consultation06/src/main/resources/output.txt")) {
//            fileWriter.write(Arrays.toString(strings));
//            fileWriter.write(intList.toString());
//            fileWriter.flush();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

    }

}