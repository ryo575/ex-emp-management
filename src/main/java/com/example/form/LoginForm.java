package com.example.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ログイン時に使用するフォーム.
 */
@Getter
@Setter
@ToString
public class LoginForm {
    /**
     * メールアドレス
     */
    @NotBlank(message = "メールアドレスは必須です")
    @Email(message = "正しいメールアドレスの形式ではありません")
    private String mailAddress;

    /**
     * パスワード
     */
    @NotBlank(message = "パスワードは必須です")
    private String password;
}
