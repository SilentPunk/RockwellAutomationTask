package resources;

import resources.state.Responsibilities;

public class Employee {

    private Responsibilities responsibilities;

    public Employee(Responsibilities responsibilities){
        this.responsibilities = responsibilities;
    }

    public Responsibilities getEmployeeResponsibilities() {
        return this.responsibilities;
    }

}

