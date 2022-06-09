import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    private static int sizeListN;
    private static int maxValue;
    private static int filterValue;

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        List<Integer> resultList = new ArrayList<>();

        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.print("Введите размер списка (целое число): ");
        sizeListN = inputIntData();

        System.out.print("Введите верхнюю границу для значений: ");
        maxValue = inputIntData();

        logger.log("Создаём и наполняем список");
        List<Integer> preResult = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < sizeListN; i++) {
            preResult.add(random.nextInt(maxValue));
        }
        System.out.print("Вот случайный список: ");
        printList(preResult);

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.print("Введите порог для фильтра:");
        filterValue = inputIntData();

        logger.log("Запускаем фильтрацию");
        Filter filter = new Filter(filterValue);
        resultList = filter.filterOut(preResult);
        logger.log(" Выводим результат на экран ");
        System.out.print("Отфильтрованный список: ");
        printList(resultList);
        logger.log("Завершаем программу");
    }

    public static int inputIntData() {
        int inputValue = 0;

        if (scanner.hasNextInt()) {
            inputValue = scanner.nextInt();
        } else {
            System.out.println("Вы ввели не целое число");
        }
        return inputValue;
    }

    public static void printList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println("");
    }
}