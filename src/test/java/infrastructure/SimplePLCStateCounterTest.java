package infrastructure;

import infrastructure.state.State;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class SimplePLCStateCounterTest {

    @Parameterized.Parameter(0)
    public List<SimplePLC> givenSimplePlcList;

    @Parameterized.Parameter(1)
    public State givenState;

    @Parameterized.Parameter(2)
    public long expectedResults;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                { new ArrayList<SimplePLC>() {
                    {
                        add(new SimplePLC(State.RUN));
                        add(new SimplePLC(State.RUN));
                        add(new SimplePLC(State.UNKNOWN));
                        add(new SimplePLC(State.PROGRAM));
                    }
                }, State.RUN, 2},
                { new ArrayList<SimplePLC>() {
                    {
                        add(new SimplePLC(State.RUN));
                        add(new SimplePLC(State.RUN));
                        add(new SimplePLC(State.UNKNOWN));
                        add(new SimplePLC(State.UNKNOWN));
                    }
                }, State.UNKNOWN, 2},
                { new ArrayList<SimplePLC>() {
                    {
                        add(new SimplePLC(State.PROGRAM));
                        add(new SimplePLC(State.PROGRAM));
                        add(new SimplePLC(State.UNKNOWN));
                        add(new SimplePLC(State.PROGRAM));
                    }
                }, State.PROGRAM, 3},
                { new ArrayList<SimplePLC>() {
                    {
                        add(new SimplePLC(State.RUN));
                        add(new SimplePLC(State.RUN));
                        add(new SimplePLC(State.RUN));
                        add(new SimplePLC(State.PROGRAM));
                    }
                }, State.UNKNOWN, 0}
        });
    }

    @Test
    public void runCounter(){
        //when
        long counterResults = SimplePLCStateCounter.countState(givenSimplePlcList, givenState);

        //then
        Assert.assertEquals(expectedResults, counterResults);
    }

}
