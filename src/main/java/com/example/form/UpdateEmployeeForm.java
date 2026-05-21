package com.example.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 従業員情報更新時に使用するフォーム.
 */
@Getter
@Setter
@ToString
public class UpdateEmployeeForm {
    /**
     * 従業員ID
     */
    @NotBlank(message = "idは必須です")
    private String id;

    /**
     * 扶養人数
     */
    @NotBlank(message = "扶養人数を入力してください")
    private String dependentsCount;

    /**
     * 入力された扶養人数をInteger型に変換する処理.
     *
     * @return Integer型に変換された扶養人数
     */
    public Integer getIntDependentsCount() {
        return Integer.parseInt(dependentsCount);
    }
}
