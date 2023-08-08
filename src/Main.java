import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Не хватает аргументов командной строки!");
            System.exit(1);
        }

        File outFile = new File(args[1]);

        switch (args[0]) {
            case ("-s"):
                ArrayList<String> strings = new ArrayList<>();

                for (int i = 2; i < args.length; i++) {
                    File file = new File(args[i]);

                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            if (line.contains(" ")) {
                                System.out.println("Файл содержит пробельные строки!");
//                                System.exit(0);
                            }
                            strings.add(line);
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("Файла " + args[i] + " не существует!");
                    }
                }
                stringValues(strings, outFile);
                break;

            case ("-i"):
                ArrayList<Integer> numbers = new ArrayList<>();

                try {
                    for (int i = 2; i < args.length; i++) {
                        File file = new File(args[i]);

                        try {
                            Scanner scanner = new Scanner(file);

                            while (scanner.hasNextLine()) {
                                numbers.add(scanner.nextInt());
                            }
                            scanner.close();

                        } catch (FileNotFoundException e) {
                            System.out.println("Файла " + args[i] + " не существует!");
                        }
                    }
                    integerValues(numbers, outFile);
                    break;
                } catch (Exception e) {
                    System.out.println("Тип переменных в файле не подходит под параметр!");
                    break;
                }

            default:
                System.out.println("Неправильный параметр!");
                break;
        }
    }

    public static void stringValues(ArrayList<String> strings, File outFile) {
        MergeSortString msObj = new MergeSortString();
        System.out.print("Полученный массив: ");
        msObj.displayArray(strings);
        msObj.mergeSort(strings, 0, strings.size() - 1);
        System.out.print("Отсортированный массив: ");
        msObj.displayArray(strings);

        try {
            if (outFile.createNewFile())
                System.out.println("Файл создан.");

            else {
                System.out.println("Файл " + outFile + " уже существует.");
            }

            PrintWriter outPrinter = new PrintWriter(outFile);

            for (String elem : strings) {
                outPrinter.println(elem);
            }
            outPrinter.close();
        } catch (Exception e) {
            System.out.println("Не удалось открыть файл!");
        }
    }

    public static void integerValues(ArrayList<Integer> numbers, File outFile) {
        MergeSortInt msObj = new MergeSortInt();
        System.out.print("Полученный массив: ");
        msObj.displayArray(numbers);
        msObj.mergeSort(numbers, 0, numbers.size() - 1);
        System.out.print("Отсортированный массив: ");
        msObj.displayArray(numbers);
        try {

            if (outFile.createNewFile())
                System.out.println("Файл создан.");
            else {
                System.out.println("Файл " + outFile + " уже существует.");
            }

            PrintWriter outPrinter = new PrintWriter(outFile);

            for (int elem : numbers) {
                outPrinter.println(elem);
            }
            outPrinter.close();
        } catch (Exception e) {
            System.out.println("Не удалось открыть файл!");
        }
    }
}