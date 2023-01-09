package lesson3;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ваши ФИО, дату рождения (dd.mm.yyyy), номер телефона и пол через пробел:");
        String input = scanner.nextLine();

        try (var writer = Files.newBufferedWriter(Paths.get("file.txt"), StandardCharsets.UTF_8)){
            isValid(input);
            fileWrite(input);
            System.out.println("Данные записаны в файл");
        } catch (RuntimeException | IOException e) {
            System.out.println("Ошибка!" + e);
        }
    }

    public static void fileWrite(String str) {
        String fileName = str.split(" ")[0] + ".txt";
        try (var writer = Files.newBufferedWriter(Paths.get(fileName), StandardCharsets.UTF_8)) {
            writer.write(str);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public static void isValid(String str){
       String[] myString = str.split(" ");
       if (myString.length != 6) {
           throw new RuntimeException("Введено неверное количество данных");
       }
       checkName(myString);
       checkDate(myString);
       checkPhone(myString);
       checkGender(myString);
    }

    public static void checkName(String[] str) {
        for (int i = 0; i < 3; i++) {
            if (!str[i].matches("[а-яА-Я]+|\\w+")) {
                throw new RuntimeException("Неверно указаны ФИО");
            }
        }
    }

    public static void checkDate(String[] str) {
        if (!str[3].matches("(0?[1-9]|[12][0-9]|3[01]).(0?[1-9]|1[012]).((19|20)\\d{2})")) {
            throw new RuntimeException("Неверный формат даты");
        }
    }

    public static void checkPhone(String[] str) {
        if (!str[4].matches("\\d{11}")) {
            throw new RuntimeException("Указан неверный номер телефона");
        }
    }

    public static void checkGender(String[] str) {
        if (!(str[5].equals("f") || str[4].equals("m"))) {
            throw new RuntimeException("Неверно указан пол");
        }
    }





}
