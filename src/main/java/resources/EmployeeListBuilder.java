package resources;

import resources.state.Responsibilities;

import java.util.ArrayList;
import java.util.List;

public class EmployeeListBuilder {

    public static List<Employee> generateListOfEmployees(int numberOfEmployees) {
        List<Employee> employeesList = new ArrayList<>();
        for (int employeeIndex = 0; employeeIndex < numberOfEmployees; employeeIndex++) {
            employeesList.add(buildEmployee(employeeIndex));
        }
        return employeesList;
    }

    private static Employee buildEmployee(int employeeIndex) {
        switch (employeeIndex) {
            case 0:
                return EmployeeFlyWeightFactory.getEmployee(Responsibilities.SET_RUN);
            case 1:
                return EmployeeFlyWeightFactory.getEmployee(Responsibilities.SET_PROGRAM);
            default:
                return EmployeeFlyWeightFactory.getEmployee(Responsibilities.SET_RUN_OR_PROGRAM);
        }
    }
}
