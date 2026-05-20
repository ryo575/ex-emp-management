package com.example.form;

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
    private String id;

    /**
     * 扶養人数
     */
    private String dependentsCount;

    public Integer getIntDependentsCount() {
        return Integer.parseInt(dependentsCount);
    }
}
