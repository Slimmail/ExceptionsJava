package Homework;

import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Scanner;

/* Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
Фамилия Имя Отчество датарождения номертелефона пол
Форматы данных:
фамилия, имя, отчество - строки
датарождения - строка формата dd.mm.yyyy
номертелефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.
Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида
<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
Не забудьте закрыть соединение с файлом.
При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.*/

public class Homework3 {
  public static void main(String[] args) {

    Person person = createPerson();
    System.out.println(person);
    addingToFile(person);
  }

  public static Person createPerson() {
    String lastName = null;
    String name = null;
    String fatherName = null;
    LocalDate dateBirth = null;
    String phoneNumber = null;
    String gender = null;

    Scanner sc = new Scanner(System.in);

    System.out.println(
        "Пожалуйста введите ваши даннные через пробел:\nФамилия Имя Отчество Дата рождения(dd.mm.yyyy) Номер телефона(целое беззнаковое число) Пол(символ латиницей f или m)\nН-р: Ivanov Ivan Ivanovich 01.01.1980 89012223344 m");
    String[] dates = sc.nextLine().split(" ");
    if (dates.length != 6) {
      if (dates.length > 6) {
        System.out.println(
            "Введенные данные некорретны. Введено больше данных чем запрошено. Советую обратить внимание на пробелы, между данными должно быть только по одному пробелу.");
      } else {
        System.out.println("Введенные данные некорретны. Введено меньше данных чем запрошено");
      }
    } else {
      if (notDigitInside(dates[0])) {
        lastName = dates[0];
      } else {
        sc.close();
        throw new RuntimeException("В фамилии присутствуют цифры. Данные некорретны");
      }
      if (notDigitInside(dates[1])) {
        name = dates[1];
      } else {
        sc.close();
        throw new RuntimeException("В имени присутствуют цифры. Данные некорретны");
      }
      if (notDigitInside(dates[2])) {
        fatherName = dates[2];
      } else {
        sc.close();
        throw new RuntimeException("В отчестве присутствуют цифры. Данные некорретны");
      }
      if (dates[3].length() == 10) {
        try {
          DateTimeFormatter germanFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
              .withLocale(Locale.GERMAN);
          dateBirth = LocalDate.parse(dates[3], germanFormatter);
        } catch (DateTimeParseException e) {
          sc.close();
          throw new RuntimeException("Введена некорретная дата рождения.");
        }
      } else {
        sc.close();
        throw new RuntimeException("Введены некорректныe данные по дате рождения");
      }
      if (dates[4].length() != 11) {
        sc.close();
        throw new RuntimeException("В номере телефона должно быть 11 цифр. Данные некорретны");
      } else {
        if (digitInside(dates[4])) {
          phoneNumber = (dates[4]);
        } else {
          sc.close();
          throw new RuntimeException("В номере телефона присутствуют некорретные символы ");
        }
      }
      if (dates[5].equals("m") || dates[5].equals("f")) {
        gender = dates[5];
      } else {
        sc.close();
        throw new RuntimeException("Введены некорректный данные по полу");
      }
    }
    sc.close();

    Person person = new Person(lastName, name, fatherName, dateBirth, phoneNumber, gender);
    return person;
  }

  public static void addingToFile(Person person) {
    try {
      FileWriter writer = new FileWriter(person.getLastName(), true);
      writer.write(person.toString() + "\n");
      writer.close();
    } catch (Exception e) {
      System.out.println("Проблемы с файлом" + e.getMessage());
    }
  }

  private static boolean notDigitInside(String string) {
    char[] chars = string.toCharArray();
    for (char character : chars) {
      if (Character.isDigit(character)) {
        return false;
      }
    }
    return true;
  }

  private static boolean digitInside(String string) {
    char[] chars = string.toCharArray();
    for (char character : chars) {
      if (Character.isDigit(character)) {
        return true;
      }
    }
    return false;
  }

}
