package in.stack.microservice.employee.controller;

import in.stack.microservice.employee.model.Employee;
import in.stack.microservice.employee.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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


    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })

    // Adding New Enployee Details In Record
    @ApiOperation(value = "Add New Employee Details",
            response = Employee.class, tags = "Employee")
    @PostMapping("/save")
    public Employee saveEmployee(@RequestBody Employee employee){
        log.info("Inside EmployeeController # aveEmployee() Method");
        return empService.save(employee);
    }


    // Displaying Employee Details By Employee ID
    @ApiOperation(value = "Get Employee Details By ID",
            response = Employee.class, tags = "Employee")
    @GetMapping("/get-one/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable int id){
        log.info("Inside EmployeeController # getEmployeeById() Method");
        return empService.findById(id);
    }

    // Displaying All Employee Details
    @ApiOperation(value = "Get ALL Employee Details ",
            response = Employee.class, tags = "Employee")
    @GetMapping("/get-all")
    public List<Employee> getAllEmployee(){
        log.info("Inside EmployeeController # getAllEmployee() Method");
        return empService.findAll();
    }

    // Deleting Employee Record BY Employee ID
    @ApiOperation(value = "Delete Employee  By ID",
            response = Employee.class, tags = "Employee")
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
    @ApiOperation(value = "Update Employee Details",
            response = Employee.class, tags = "Employee")
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
