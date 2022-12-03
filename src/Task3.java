//        В калькулятор добавьте возможность отменить последнюю операцию.

import java.io.IOException;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class Task3 {

    public static void main(String[] args) throws IOException {
        calculator();
    }


    public static void calculator() throws IOException {
        System.out.println("Реализовать простой калькулятор");
        Logger logger = Logger.getLogger(Task2.class.getName());
        FileHandler myHandler = new FileHandler("calc_log.xml");
        logger.addHandler(myHandler);
        XMLFormatter xml = new XMLFormatter();
        myHandler.setFormatter(xml);
        logger.info("Запуск программы");
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        ArrayDeque <Float> previousValues = new ArrayDeque<>();
        float currentNumber = 0;
        float operand = 0;
        int operation = 0;
        while(flag) {
            logger.info(String.format("Текущее число %f", currentNumber));
            System.out.printf("1.Сложить\n2.Отнять\n3.Умножить\n4.Разделить\n5.Обнулить текущее число\n6.Отменить последнюю операцию\n9.Выход\nТекущее число: %f\nВведите команду:", currentNumber);
            operation = scanner.nextInt(); //здесь ещё нужно отработать исключение - только int (как то через try catch)
            switch (operation) {
                case (1):
                    previousValues.addLast(currentNumber);
                    System.out.print("Введите второе слогаемое: ");
                    operand = scanner.nextFloat();
                    currentNumber += operand;
                    logger.info(String.format("Произведено сложение с числом %f", operand));
                    break;
                case (2):
                    previousValues.addLast(currentNumber);
                    System.out.print("Введите вычитаемое число: ");
                    operand = scanner.nextFloat();
                    currentNumber -= operand;
                    logger.info(String.format("Произведено вычитание на число %f", operand));
                    break;
                case (3):
                    previousValues.addLast(currentNumber);
                    System.out.print("Введите второй множитель: ");
                    operand = scanner.nextFloat();
                    currentNumber *= operand;
                    logger.info(String.format("Произведено умножение на число %f", operand));
                    break;
                case (4):
                    previousValues.addLast(currentNumber);
                    System.out.print("Введите делитель число: ");
                    operand = scanner.nextFloat();
                    currentNumber /= operand;
                    logger.info(String.format("Произведено деление на число %f", operand));
                    break;
                case (5):
                    previousValues.addLast(currentNumber);
                    currentNumber = 0;
                    logger.info("Произведён сброс на ноль");
                    break;
                case (6):
                    if (previousValues.size() > 0) {
                        currentNumber = previousValues.removeLast();
                        logger.info("Отмена последней операции");
                    }
                    else {
                        System.out.println("Более ранних данных нет");
                        logger.info("Ошибка отмены последней операции");
                    }
                    break;
                case (9):
                    flag = false;
                    System.out.println("До скорых встреч");
                    logger.info("Выход из программы");
                    break;
                default:
                    System.out.println("Некоректный ввод");
                    logger.info(String.format("Произведён некорректноый ввод. Пользователь ввёл %d", operation));
                    break;

            }

        }

    }
}
