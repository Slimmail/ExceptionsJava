package Homework;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Homework2 {

  public static void main(String[] args) {
    // floatNumber();
    // secondExercise​();
    // thirdExercise​();
    // inputString();

  }

  // 1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа
  // (типа float), и возвращает введенное значение. Ввод текста вместо числа не
  // должно приводить к падению приложения, вместо этого, необходимо повторно
  // запросить у пользователя ввод данных.
  public static void floatNumber() {
    System.out.println("Введите дробное число: ");
    Scanner sc = new Scanner(System.in);
    try {
      String name = sc.nextLine();
      float number = Float.valueOf(name);
      System.out.println(number);
    } catch (NumberFormatException e) {
      System.out.println("Введено не дробное число. Необходимо ввести дробное число!");
      floatNumber();
    }
    sc.close();
  }

  // 2. Исправить код
  /**
   * try {
   * int d = 0;
   * double catchedRes1 = intArray[8] / d;
   * System.out.println("catchedRes1 = " + catchedRes1);
   * }catch(
   * ArithmeticException e)
   * {
   * System.out.println("Catching exception: " + e);
   * }
   **/

  public static void secondExercise​() {
    int d = 0;
    int[] intArray = { 1, 5, 5, 8, 3, 4, 25, 4, 31, 0 };
    if (d == 0) {
      throw new ArithmeticException("Catching exception: делить на ноль нельзя");
    }
    double catchedRes1 = Double.valueOf(intArray[8]) / d;
    System.out.println("catchedRes1 = " + catchedRes1);

  }

  // 3. Исправить код
  /**
   * public static void main(String[] args) throws Exception {
   * try {
   * int a = 90;
   * int b = 3;
   * System.out.println(a / b);
   * printSum(23, 234);
   * int[] abc = { 1, 2 };
   * abc[3] = 9;
   * } catch (Throwable ex) {
   * System.out.println("Что-то пошло не так...");
   * } catch (NullPointerException ex) {
   * System.out.println("Указатель не может указывать на null!");
   * } catch (IndexOutOfBoundsException ex) {
   * System.out.println("Массив выходит за пределы своего размера!");
   * }
   * }
   * public static void printSum(Integer a, Integer b) throws
   * FileNotFoundException {
   * System.out.println(a + b);
   * }
   **/
  public static void thirdExercise​() {
    try {
      int a = 90;
      int b = 3;
      // int b = 0; // ошибка ArithmeticException
      System.out.println(a / b);
      printSum(23, 234);
      // printSum(23, null); // ошибка NullPointerException
      int[] abc = { 1, 2 };
      abc[3] = 9; // обшибка IndexOutOfBoundsException
    } catch (ArithmeticException ex) {
      System.out.println("На ноль делить нельзя");
    } catch (NullPointerException ex) {
      System.out.println("Указатель не может указывать на null!");
    } catch (IndexOutOfBoundsException ex) {
      System.out.println("Массив выходит за пределы своего размера!");
    } catch (FileNotFoundException ex) {
      System.out.println("Что-то пошло не так...");
    }
  }

  public static void printSum(Integer a, Integer b) throws FileNotFoundException {
    System.out.println(a + b);
  }

  // 4. Разработайте программу, которая выбросит Exception, когда пользователь
  // вводит пустую строку. Пользователю должно показаться сообщение, что пустые
  // строки вводить нельзя.
  public static void inputString() {
    System.out.println("Введите сообщение: ");
    Scanner sc = new Scanner(System.in);
    String message = sc.nextLine();
    if (message.isEmpty()) {
      sc.close();
      throw new RuntimeException("Пустые строки вводить нельзя!");
    }
    System.out.println(message);
    sc.close();
  }

}
