package controllers;

import infrastructure.SimplePLC;
import infrastructure.state.State;
import resources.Employee;

import java.util.List;

public class BasicController {

    public static void changeState(List<Employee> employeesList, List<SimplePLC> simplePLCList){
        for (int iterator = 0 ; iterator < employeesList.size() ; iterator++){
            int plcIdentifier = iterator;
            Employee employee = employeesList.get(iterator);
            while (plcIdentifier < employeesList.size()){
                SimplePLC simplePLC = simplePLCList.get(plcIdentifier);
                setStateOfSimplePLC(employee, simplePLC);

                plcIdentifier += iterator + 1;
            }
        }
    }

    private static void setStateOfSimplePLC(Employee employee, SimplePLC simplePLC){
        switch (employee.getEmployeeResponsibilities()){
            case SET_RUN:
                simplePLC.setState(State.RUN);
                break;
            case SET_PROGRAM:
                simplePLC.setState(State.PROGRAM);
                break;
            case SET_RUN_OR_PROGRAM:
                setDefaultState(simplePLC);
        }
    }

    private static void setDefaultState(SimplePLC simplePLC){
        State stateOfSimplePlc = simplePLC.getState();
        switch (stateOfSimplePlc) {
            case PROGRAM:
                simplePLC.setState(State.RUN);
                break;
            case RUN:
                simplePLC.setState(State.PROGRAM);
                break;
        }
    }


}
