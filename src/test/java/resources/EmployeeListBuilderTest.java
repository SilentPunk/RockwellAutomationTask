package resources;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Equator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import resources.state.Responsibilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class EmployeeListBuilderTest {

    @Parameterized.Parameter(0)
    public int givenNumberOfEmployee;

    @Parameterized.Parameter(1)
    public List<Employee> expectedListOfEmployee;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {2, new ArrayList<Employee>(){
                    {
                        add(new Employee(Responsibilities.SET_RUN));
                        add(new Employee(Responsibilities.SET_PROGRAM));
                    }
                }},
                {3, new ArrayList<Employee>(){
                    {
                        add(new Employee(Responsibilities.SET_RUN));
                        add(new Employee(Responsibilities.SET_PROGRAM));
                        add(new Employee(Responsibilities.SET_RUN_OR_PROGRAM));
                    }
                }},
                {4, new ArrayList<Employee>(){
                    {
                        add(new Employee(Responsibilities.SET_RUN));
                        add(new Employee(Responsibilities.SET_PROGRAM));
                        add(new Employee(Responsibilities.SET_RUN_OR_PROGRAM));
                        add(new Employee(Responsibilities.SET_RUN_OR_PROGRAM));
                    }
                }},
        });
    }

    @Test
    public void generateListOfEmployee(){
        //when
        List<Employee> actualListOfEmployee = EmployeeListBuilder.generateListOfEmployees(givenNumberOfEmployee);

        //then
        Assert.assertTrue(CollectionUtils.isEqualCollection(actualListOfEmployee, expectedListOfEmployee, initializeEmployeeEquator()));
    }

    private Equator<Employee> initializeEmployeeEquator() {
        return new Equator<Employee>() {
            @Override
            public boolean equate(Employee o1, Employee o2) {
                return o1.getEmployeeResponsibilities().equals(o2.getEmployeeResponsibilities());
            }

            @Override
            public int hash(Employee o) {
                return 0;
            }
        };
    }

}
