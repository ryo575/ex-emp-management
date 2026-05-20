package com.example.form;

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
    private String mailAddress;

    /**
     * パスワード
     */
    private String password;
}
