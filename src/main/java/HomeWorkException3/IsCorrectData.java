package HomeWorkException3;

import java.util.Arrays;
import java.util.regex.Pattern;

public class IsCorrectData {
    public static boolean isValidUseData(String useData) {
        String[] useDataCells = useData.trim().split("\\s+");
        if (isValidSizeData(useDataCells) &&
                isStringUseData(useDataCells[0]) &&
                isStringUseData(useDataCells[1]) &&
                isStringUseData(useDataCells[2]) &&
                isStringValidDataBirthday(useDataCells[3]) &&
                isPhone(useDataCells[4]) &&
                isStringGender(useDataCells[5])) {
            return true;
        }
        return false;
    }

    static boolean isValidSizeData(String[] useDataCells) {
        int validSize = 6;
        if (useDataCells.length != validSize) {
            throw new RuntimeException("Вы  ввели меньше (больше) данных, чем требуется для создания пользователя!");
        }
        return true;
    }

    static boolean isStringUseData(String useString) { // проверка имени, фамилии, отчества на соответствие
        if (!useString.matches("[a-zA-Z]+\\.?")) {
            throw new RuntimeException("Некорректный ввод фамилии, имени или отчества!");
        }
        return true;
    }//"^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";

    static boolean isStringValidDataBirthday(String useString) { // проверка валидности имени, фамилии, отчества
        if (!useString.matches("^(1[0-2]|0[1-9]).(3[01]|[12][0-9]|0[1-9]).[0-9]{4}$")) {
            throw new RuntimeException("Некорректный ввод даты рождения!");
        }
        return true;
    }

    static boolean isPhone(String useString) { //проверка на валидность номера
        String str = "^\\s?((\\+[1-9]{2}[ \\-]*)|(\\([0-9]{3}\\)[ \\-]*)|([0-9]{3})[ \\-]*)*?[0-9]{2}?[ \\-]*[0-9]{2}?\\s?";
        if (!Pattern.compile(str).matcher(useString).matches()) {
            throw new RuntimeException("Некорректный ввод номера телефона!");
        }
        return true;
    }

    static boolean isStringGender(String useString) { // проверка на валидность пола
        if (!Arrays.stream(Gender.values()).anyMatch(e -> e.name().equals(useString.toUpperCase()))) {
            throw new RuntimeException("Некорректный ввод пола!");
        }
        return true;
    }
}
