package com.example.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

/**
 * 管理者登録時に使用するフォーム
 */

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
