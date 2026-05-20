package com.example.domain;

import lombok.*;

/**
 * 管理者を表すドメイン.
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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
