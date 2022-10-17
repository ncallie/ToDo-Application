package ru.ncallie.ToDo.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationDTO {
    @NotBlank
    @Size(min = 5, max = 15, message = "От 5 до 15 символов") @Pattern(regexp = "\\w+", message = "Только латинские прописные буквы")
    private String username;
    @NotBlank  @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$", message = "Минимум восемь символов, минимум одна заглавная буква, одна строчная буква и одна цифра")
    private String password;
}
