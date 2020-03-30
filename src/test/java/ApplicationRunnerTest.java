import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ApplicationRunnerTest {

    @Parameterized.Parameter(0)
    public int givenNumberOfEmployeeAndPLC;

    @Parameterized.Parameter(1)
    public long expectedResults;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1100, 33},
                {1200, 34}
        });
    }

    @Test
    public void calculateNumbersOfRunPLCForGivenNumber(){
        //when
        long actualResults = ApplicationRunner.run(givenNumberOfEmployeeAndPLC);

        //then
        Assert.assertEquals(expectedResults, actualResults);
    }

}
