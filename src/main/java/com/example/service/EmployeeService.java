package com.example.service;

import com.example.domain.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 従業員情報一覧を全件検索する業務処理を行う.
 */
@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * 従業員情報を全件取得.
     *
     * @return 従業員情報リスト
     */
    public List<Employee> showList() {
        List<Employee> employeeList = employeeRepository.findAll();

        return employeeList;
    }

    /**
     * 従業員情報を取得する.
     *
     * @param id 従業員id
     * @return 従業員情報
     */
    public Employee showDetail(Integer id) {
        Employee employee = employeeRepository.findById(id);

        return employee;
    }

    /**
     * 従業員情報を更新する.
     *
     * @param employeeId 従業員ID
     * @param newCount   更新する扶養人数
     */
    public void updateDependentsCount(Integer employeeId, Integer newCount) {
        Employee employee = employeeRepository.findById(employeeId);

        employee.setDependentsCount(newCount);
        employeeRepository.update(employee);
    }
}
