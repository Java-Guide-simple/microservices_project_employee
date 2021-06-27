package in.stack.microservice.employee.controller;

import in.stack.microservice.employee.model.Employee;
import in.stack.microservice.employee.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    // Adding New Enployee Details In Record
    @PostMapping("/save")
    public Employee saveEmployee(@RequestBody Employee employee){
        log.info("Inside EmployeeController # aveEmployee() Method");
        return empService.save(employee);
    }
    // Displaying Employee Details By Employee ID
    @GetMapping("/get-one/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable int id){
        log.info("Inside EmployeeController # getEmployeeById() Method");
        return empService.findById(id);
    }

    // Displaying All Employee Details
    @GetMapping("/get-all")
    public List<Employee> getAllEmployee(){
        log.info("Inside EmployeeController # getAllEmployee() Method");
        return empService.findAll();
    }

    // Deleting Employee Record BY Employee ID
    @DeleteMapping("/delete/{id}")
    public  String deleteEmployee(@PathVariable int id){
        log.info("Inside EmployeeController # deleteEmployee() Method");
        Boolean deleted=false;
        deleted = empService.deleteEmployee(id);
        if (deleted)
            return "Successfully Deleted";
        else
            return "Something Wrong please check input";
    }
    // Updating Employee Details (Sending Employee Details With ID Which Is already Present In Record)
    @PutMapping("/update")
    public String updateEmployee(@RequestBody Employee employee){
        log.info("Inside EmployeeController # pdateEmployee() Method");
        Employee updated = empService.UpdateEmployee(employee);
        if (updated!=null)
             return "Updated";
        else
            return "Something Wrong";
    }
}
