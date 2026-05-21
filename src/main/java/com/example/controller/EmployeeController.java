package com.example.controller;

import com.example.domain.Employee;
import com.example.form.UpdateEmployeeForm;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * 従業員情報を検索する処理を行う.
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /**
     * 従業員一覧を出力.
     *
     * @param model 従業員一覧格納用リクエストスコープ
     * @return 従業員一覧画面
     */
    @GetMapping("/show-list")
    public String showList(Model model) {
        List<Employee> employeeList = employeeService.showList();
        model.addAttribute("employeeList", employeeList);

        return "employee/list";
    }

    /**
     * 従業員IDをもとに従業員情報を取得.
     *
     * @param id    従業員id
     * @param model リクエストスコープ
     * @param form  フォーム
     * @return 従業員情報画面
     */
    @GetMapping("/show-detail")
    public String showDetail(String id, Model model, UpdateEmployeeForm form) {
        Employee employee = employeeService.showDetail(Integer.parseInt(id));

        model.addAttribute("employee", employee);

        return "employee/detail";
    }

    /**
     * 扶養人数を更新.
     *
     * @param form フォーム
     * @return 従業員一覧画面
     */
    @PostMapping("/update")
    public String update(@Validated UpdateEmployeeForm form,
                         BindingResult result,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        if (result.hasErrors()) {
            Employee employee = employeeService.showDetail(Integer.parseInt(form.getId()));

            model.addAttribute("employee", employee);
            return "employee/detail";
        }

        employeeService.updateDependentsCount(Integer.parseInt(form.getId()), form.getIntDependentsCount());

        return "redirect:/employee/show-list";
    }
}
