package resources;

import resources.state.Responsibilities;

import java.util.HashMap;
import java.util.Map;

public class EmployeeFlyWeightFactory {
    private static Map<Responsibilities, Employee> employeeMap = new HashMap<>();

    public static Employee getEmployee(Responsibilities responsibilities){
        Employee employee = employeeMap.get(responsibilities);
        if (employee == null){
            employee = new Employee(responsibilities);
            employeeMap.put(responsibilities, employee);
        }
        return employee;
    }

}
