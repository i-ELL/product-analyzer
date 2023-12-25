package analyzer.domain.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRegisterDTO {
    @NotEmpty(message = "Поле имя не может быть пустым")
    private String username;

    @NotEmpty(message = "Поле имя не может быть пустым")
    private String email;

    @NotEmpty(message = "Поле пароль не может быть пустым")
    private String password;
}