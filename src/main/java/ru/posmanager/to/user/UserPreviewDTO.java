package ru.posmanager.to.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.posmanager.to.BaseDTO;
import ru.posmanager.to.bank.DepartmentDTO;

import java.util.Objects;

@Data
@NoArgsConstructor
public class UserPreviewDTO extends BaseDTO {
    protected String firstName;

    protected String lastName;

    protected String middleName;

    protected String city;

    protected DepartmentDTO department;

    protected String email;

    public UserPreviewDTO(UserPreviewDTO to) {
        this(to.id, to.firstName, to.lastName, to.middleName, to.city, to.department, to.email);
    }

    public UserPreviewDTO(String firstName, String lastName, String middleName,
                          String city, DepartmentDTO department, String email) {
        this(null, firstName, lastName, middleName, city, department, email);
    }

    public UserPreviewDTO(Integer id, String firstName, String lastName, String middleName,
                          String city, DepartmentDTO department, String email) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.city = city;
        this.email = email;
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserPreviewDTO that = (UserPreviewDTO) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(middleName, that.middleName) && Objects.equals(city, that.city) && Objects.equals(department, that.department) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, lastName, middleName, city, department, email);
    }
}