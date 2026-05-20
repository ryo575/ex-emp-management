package com.example.form;

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
    private String name;
    /**
     * メールアドレス
     */
    private String mailAddress;
    /**
     * パスワード
     */
    private String password;
}
