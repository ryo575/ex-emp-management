package com.example.domain;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

/**
 * 管理者を表すクラスです
 */

public class Administrator {
    /**
     * 従業員ID
     */
    private Integer id;
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
