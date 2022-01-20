package com.company;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Map<LocalDate, List<String>> libraryReport = new TreeMap<>();
        // Існує деякий список книг, які були в конкретний день вилучені з бібліотеки
        libraryReport.put(LocalDate.of(2022, 1, 9), List.of("Гаррі Потер", "Принц Вільям"));
        libraryReport.put(LocalDate.of(2022, 1, 10), List.of("Пепі довга панчоха", "Казки Уейна"));
        libraryReport.put(LocalDate.of(2022, 1, 11), List.of("Людина розумна", "Історія України"));
        libraryReport.put(LocalDate.of(2022, 1, 12), List.of("Комедія для дорослих", "Чарівна квітка"));
        libraryReport.put(LocalDate.of(2022, 1, 13), List.of("Комедія для дорослих", "Чарівна квітка"));
        searchByDates(libraryReport); // виклик метода для пошуку по даті
        searchByIntervalDate(libraryReport); // виклик метода для пошуку книг за певний період часу
    }
    static void searchByDates(Map<LocalDate, List<String>> library) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введіть рік:");
            int year = scanner.nextInt();
            System.out.println("Введіть місяць:");
            int mouth = scanner.nextInt();
            System.out.println("Введіть день :");
            int day = scanner.nextInt();
            LocalDate date = LocalDate.of(year, mouth, day);
            if (library.get(date) == null) {
                System.out.println("По даті " + date + " нічого не знайдено\nДоступні дати: ");
                for (Map.Entry entry : library.entrySet()) {
                    System.out.println(entry.getKey());
                }
            } else {
                System.out.println("По даті " + date + " знайдено такі книжки:" + library.get(date));
                System.out.println("Кількість книжок по даній даті " + library.get(date).size());
            }
        } catch (Exception e) {
            System.out.println("Некоректно введена дата");
        }
    }
    static void searchByIntervalDate(Map<LocalDate, List<String>> library) {
        try {
            System.out.println("Пошук книг по за певний період часу:");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введіть початковий рік:");
            int yearStart = scanner.nextInt();
            System.out.println("Введіть почтковий місяць:");
            int mouthStart = scanner.nextInt();
            System.out.println("Введіть почтковий день:");
            int dayStart = scanner.nextInt();
            System.out.println("Введіть кінцевий рік:");
            int yearFinish = scanner.nextInt();
            System.out.println("Введіть кінцевий місяць:");
            int mouthFinish = scanner.nextInt();
            System.out.println("Введіть кінцевий день:");
            int dayFinish = scanner.nextInt();
            System.out.println("Результати пошуку:");
            LocalDate dateStart = LocalDate.of(yearStart, mouthStart, dayStart);
            LocalDate dateFinish = LocalDate.of(yearFinish, mouthFinish, dayFinish);
            for (Map.Entry entry : library.entrySet()) {
                if (entry.getKey().hashCode() >= dateStart.hashCode()) {
                    System.out.println("Дата " + entry.getKey() + " Книги " + entry.getValue());
                }
                if (entry.getKey().equals(dateFinish)) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Некоректно введена дата");
        }
    }
}

