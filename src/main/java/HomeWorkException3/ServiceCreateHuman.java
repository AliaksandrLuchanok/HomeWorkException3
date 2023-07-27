package HomeWorkException3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ServiceCreateHuman {
    public static void createHuman() throws Exception {
        //Чтение данных из консоли и преобразование в массив строк
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные через пробел согласно образцу:\n" +
                "\t\t\t\tФамилия Имя Отчество датарождения номертелефона пол, например: \n" +
                "\t\t\t\tPetrov Vadim Petrovich 09.29.1965 +29-143-45-15 male");
        String useDataHuman = scanner.nextLine();
        String[] useDataCells = useDataHuman.trim().split("\\s+");
        if (IsCorrectData.isValidUseData(useDataHuman)) {           // проверка валидности вводимых данных
            CreateHuman newHuman = new CreateHuman(useDataCells);   // создание нового человека
            String lastName = useDataCells[0];                      // создание переменной для создания пути файла
            String pathFile = lastName + ".txt";
            scanner.close();                                        // создание переменной для создания пути файла
            System.out.printf("Creation newHuman:\n\t\t\t%s \nwas successful", newHuman);

            try (FileWriter writer = new FileWriter(pathFile, true);
                 BufferedWriter bufferWriter = new BufferedWriter(writer)) { // закрытие автоматически
                bufferWriter.write(newHuman.toString() + "\n");    // запись данных по фамилии человека
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else {
            createHuman();
        }
    }
}
