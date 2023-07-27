package HomeWorkException3;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Iterator;
import java.util.Objects;

@Data
@AllArgsConstructor
public class Human implements Iterator<String> {

    private String lastName;
    private String firstName;
    private String patronymic;
    private String dateOfBirth;
    private String phoneNumber;
    private String gender;

    public Human(String lastName, String firstName, String patronymic, String dateOfBirth, String phoneNumber, String gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("<%s><%s><%s><%s><%s><%s>", getLastName(), getFirstName(),
                getPatronymic(), getDateOfBirth(),
                getPhoneNumber(), getGender())
                ;
    }

    int index;

    @Override
    public boolean hasNext() {
        return index++ < 6;
    }

    @Override
    public String next() {
        switch (index){
            case 0:
                return getLastName();
            case 1:
                return getFirstName();
            case 2:
                return getPatronymic();
            case 3:
                return getDateOfBirth();
            case 4:
                return getPhoneNumber();
            default:
                return getGender();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human human)) return false;
        return index == human.index
                                    && Objects.equals(lastName, human.lastName)
                                    && Objects.equals(firstName, human.firstName)
                                    && Objects.equals(patronymic, human.patronymic)
                                    && Objects.equals(dateOfBirth, human.dateOfBirth)
                                    && Objects.equals(phoneNumber, human.phoneNumber)
                                    && Objects.equals(gender, human.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, patronymic, dateOfBirth, phoneNumber, gender);
    }
}
