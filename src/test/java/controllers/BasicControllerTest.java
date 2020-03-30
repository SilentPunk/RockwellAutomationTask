package controllers;

import infrastructure.SimplePLC;
import infrastructure.state.State;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Equator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import resources.Employee;
import resources.state.Responsibilities;

import java.util.*;

@RunWith(Parameterized.class)
public class BasicControllerTest {

    @Parameterized.Parameter(0)
    public List<Employee> employeeList;

    @Parameterized.Parameter(1)
    public List<SimplePLC> plcList;

    @Parameterized.Parameter(2)
    public List<SimplePLC> expectedResults;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        new ArrayList<Employee>() {
                            {
                                add(new Employee(Responsibilities.SET_RUN));
                                add(new Employee(Responsibilities.SET_PROGRAM));
                                add(new Employee(Responsibilities.SET_RUN_OR_PROGRAM));
                                add(new Employee(Responsibilities.SET_RUN_OR_PROGRAM));
                            }
                        },
                        new ArrayList<SimplePLC>() {
                            {
                                add(new SimplePLC());
                                add(new SimplePLC());
                                add(new SimplePLC());
                                add(new SimplePLC());
                            }
                        },
                        new ArrayList<SimplePLC>() {
                            {
                                add(new SimplePLC(State.RUN));
                                add(new SimplePLC(State.PROGRAM));
                                add(new SimplePLC(State.PROGRAM));
                                add(new SimplePLC(State.RUN));

                            }
                        }
                },
        });
    }

    @Test
    public void shouldChangeState() {
        //when
        BasicController.changeState(employeeList, plcList);
        //then
        Assert.assertTrue(CollectionUtils.isEqualCollection(expectedResults, plcList, initializeEquator()));


    }

    private Equator<SimplePLC> initializeEquator() {
        return new Equator<SimplePLC>() {
            @Override
            public boolean equate(SimplePLC o1, SimplePLC o2) {
                return o1.getState().equals(o2.getState());
            }

            @Override
            public int hash(SimplePLC o) {
                return 0;
            }
        };
    }
}
