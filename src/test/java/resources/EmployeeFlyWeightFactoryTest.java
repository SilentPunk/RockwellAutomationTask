package resources;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import resources.state.Responsibilities;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class EmployeeFlyWeightFactoryTest {

    @Parameterized.Parameter(0)
    public Responsibilities employeeResponsibilities;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Responsibilities.SET_PROGRAM},
                {Responsibilities.SET_RUN},
                {Responsibilities.SET_RUN_OR_PROGRAM}
        });
    }

    @Test
    public void checkIfFactoryReturnsTheSameObject() {
        //when
        Employee employee1 = EmployeeFlyWeightFactory.getEmployee(employeeResponsibilities);
        Employee employee2 = EmployeeFlyWeightFactory.getEmployee(employeeResponsibilities);

        //then
        Assert.assertSame(employee1, employee2);
    }


}
