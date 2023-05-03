package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    EmployeeService employeeServiceImpl;



    @PostMapping("/signUp")
    public ResponseEntity<String>signUp(@RequestBody Employee employee) {
    employeeServiceImpl.signUp(employee);
    return ResponseEntity.ok("signup Done Sucsessfully");
    }

    @GetMapping("/signIn/{empEmailId}/{empPassword}")
    public  ResponseEntity<Boolean>signIn(@PathVariable String empEmailId ,@PathVariable String empPassword){
        return ResponseEntity.ok(employeeServiceImpl.signIn(empEmailId,empPassword));
    }

    @GetMapping("/getDataById/{empId}")
    public  ResponseEntity<Employee>getDataById(@PathVariable int empId){
        return ResponseEntity.ok(employeeServiceImpl.getDataById(empId));
    }

    @PostMapping("/saveBulkOfData")
    public ResponseEntity<String>saveBulkOfData(@RequestBody List<Employee>employees){
        employeeServiceImpl.saveBulkOfData(employees);
    return ResponseEntity.ok("Bulk Of Data Saved Successfully");
    }

    @GetMapping("/getAllData")
    public ResponseEntity<List<Employee>>getAllData(){

        return ResponseEntity.ok(employeeServiceImpl.getAllData());
    }

    @PutMapping ("/updateData/{empId}")
    public ResponseEntity<String>UpdateData( @PathVariable int empId ,@RequestBody Employee employee){
        employeeServiceImpl.updateData(employee,empId);
        return ResponseEntity.ok("Data updated Saved Successfully");
    }

    @GetMapping("/getDataByUsingAnyInput/{input}")

    public  ResponseEntity<List<Employee>>getDataByUsingAnyInput(@PathVariable String input){

        return ResponseEntity.ok(employeeServiceImpl.getDataByUsingAnyInput(input));
    }
    @GetMapping("/getDataByContactNumber/{empContactNumber}")

    public  ResponseEntity<Employee>getDataByContactNumber(@PathVariable long empContactNumber){

        return ResponseEntity.ok(employeeServiceImpl.getAllData().stream().filter
                (employee -> employee.getEmpContactNumber()==empContactNumber).collect(Collectors.toList()).get(0));
    }
    @GetMapping("/getDataUsingEmailId/empEmailId")

    public  ResponseEntity<Employee>getDataUsingEmailId(@PathVariable String empEmailId){
        return ResponseEntity.ok(employeeServiceImpl.getAllData().stream().filter(employee -> employee.getEmpEmailId().equals(empEmailId)).collect(Collectors.toList()).get(0));
    }
    @GetMapping("/sortByName")
    public ResponseEntity<List<Employee>>sortByName(){
        return ResponseEntity.ok(employeeServiceImpl.getAllData().stream().sorted(Comparator.comparing(Employee::getEmpName)).collect(Collectors.toList()));
    }

    @DeleteMapping("/deleteDataById/{empId}")
    public ResponseEntity<String>deleteDataById(@PathVariable int empId){
        employeeServiceImpl.deleteDataById(empId);
    return ResponseEntity.ok("Data Deleted By Id");
    }
    @DeleteMapping("/deleteAllData")
    public ResponseEntity<String>deleteAllData(){
        employeeServiceImpl.deleteAllData();
        return ResponseEntity.ok("Data Deleted ");
    }
    @GetMapping("/sortByDob")
    public ResponseEntity<List<Employee>>sortBydob(){

        return ResponseEntity.ok(employeeServiceImpl.getAllData().stream().sorted(Comparator.comparing(Employee::getEmpDOB).reversed()).collect(Collectors.toList()));
    }

    @DeleteMapping("/sayhello")
    public ResponseEntity<String>sayHello(){

        return ResponseEntity.ok("hello ");
    }
}

