package com.csi.service;

import com.csi.dao.EmployeeDao;
import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeDao employeeServiceImpl;

    @Override
    public void signUp(Employee employee) {

         employeeServiceImpl.signUp(employee);

    }

    @Override
    public boolean signIn(String empEmailId, String empPassword) {
        return  employeeServiceImpl.signIn(empEmailId,empPassword);
    }

    @Override
    public void saveBulkOfData(List<Employee> employees) {

        employeeServiceImpl.saveBulkOfData(employees);
    }

    @Override
    public List<Employee> getDataByUsingAnyInput(String input) {
        return  employeeServiceImpl.getDataByUsingAnyInput(input);
    }

    @Override
    public Employee getDataById(int empId) {
        return  employeeServiceImpl.getDataById(empId);
    }

    @Override
    public List<Employee> getAllData() {
        return  employeeServiceImpl.getAllData();
    }

    @Override
    public void updateData(Employee employee, int empId) {

        employeeServiceImpl.updateData(employee,empId);
    }

    @Override
    public void deleteDataById(int empId) {
        employeeServiceImpl.deleteDataById(empId);

    }

    @Override
    public void deleteAllData() {
        employeeServiceImpl.deleteAllData();

    }
}
