package com.example.contact.contact;

import com.sun.istack.internal.NotNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Data
//@Entity
@Document
public class Contact {
    @Id
    private String id;

    @NotNull
    @Size(min = 1,message = "名字至少有1个字符")
    private String firstName;

    @NotNull
    @Size(min = 1,message = "名字至少有1个字符")
    private String lastName;

    @Pattern(regexp = "^1([34578])\\d{9}$", message = "无效的手机号")
    private String phoneNumber;

    @NotBlank(message = "此处不能为空")
    @Email
    private String emailAddress;

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(firstName, contact.firstName) && Objects.equals(lastName, contact.lastName) && Objects.equals(phoneNumber, contact.phoneNumber) && Objects.equals(emailAddress, contact.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phoneNumber, emailAddress);
    }
}