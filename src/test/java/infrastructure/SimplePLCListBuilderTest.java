package infrastructure;

import infrastructure.state.State;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import resources.Employee;
import resources.state.Responsibilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class SimplePLCListBuilderTest {

    @Parameterized.Parameter(0)
    public int givenListOfSimplePlc;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {5},
                {10},
                {15},
                {20},
        });
    }

    @Test
    public void createListOfSimplePlc(){
        //when
        List<SimplePLC> simplePLCList = SimplePLCListBuilder.generateListOfSimplePLC(givenListOfSimplePlc);

        //Then
        Assert.assertEquals(givenListOfSimplePlc, simplePLCList.size());
    }

}
