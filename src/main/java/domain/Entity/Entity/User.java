package domain.Entity.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "닉네임을 입력해주세요.")
    @Size(min = 2, max = 10, message = "닉네임은 2자 이상 10자 이하여야 합니다.")
    @Column(nullable = false, unique = true)
    private String username;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Size(min =8, max = 15, message = "비밀번호는 8자 이상 15자 이하여야 합니다.")
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[!@#$%^&*()_+\\-={}\\[\\]:;\"'`~,<.>/?])(?!.*\\s){8,}$",
            message = "비밀번호는 소문자, 숫자, 특수문자가 포함되어야 합니다."
    )
    @Column(nullable = false)
    private String password;

    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "적합한 이메일 형식이 아닙니다.")
    @Column(nullable = false, unique = true)
    private String email;

}
