import controllers.BasicController;
import infrastructure.SimplePLC;
import infrastructure.SimplePLCListBuilder;
import infrastructure.SimplePLCStateCounter;
import infrastructure.state.State;
import resources.Employee;
import resources.EmployeeListBuilder;

import java.util.List;

public final class ApplicationRunner {

    public static final long run(int numberOfEmployeesAndPLC){
        List<Employee> employeesList = EmployeeListBuilder.generateListOfEmployees(numberOfEmployeesAndPLC);
        List<SimplePLC> simplePLCList = SimplePLCListBuilder.generateListOfSimplePLC(numberOfEmployeesAndPLC);

        BasicController.changeState(employeesList, simplePLCList);

        long count = SimplePLCStateCounter.countState(simplePLCList, State.RUN);

        return count;
    }
}
