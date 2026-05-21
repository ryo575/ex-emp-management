package com.example.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 管理者登録時に使用するフォーム.
 */

@Getter
@Setter
@ToString
public class InsertAdministratorForm {

    /**
     * 名前
     */
    @NotBlank(message = "名前は必須です")
    private String name;
    /**
     * メールアドレス
     */
    @NotBlank(message = "メールアドレスは必須です")
    @Email(message = "正しいメールアドレスの形式で入力してください")
    private String mailAddress;
    /**
     * パスワード
     */
    @NotBlank(message = "パスワードは必須です")
    private String password;
}
