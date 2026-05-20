package com.example.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class InsertAdministratorForm {

    /*
    名前
     */
    private String name;
    /*
    メールアドレス
     */
    private String mailAddress;
    /*
    パスワード
     */
    private String password;
}
