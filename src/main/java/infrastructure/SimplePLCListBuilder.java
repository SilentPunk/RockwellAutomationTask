package infrastructure;

import java.util.ArrayList;
import java.util.List;

public class SimplePLCListBuilder {

    public static List<SimplePLC> generateListOfSimplePLC(int numberOfPlc){
        List<SimplePLC> simplePLCList = new ArrayList<>();
        SimplePLC simplePLCDefault = new SimplePLC();
        for (int simplePlcIndex = 0 ; simplePlcIndex < numberOfPlc ; simplePlcIndex ++){
            simplePLCList.add(simplePLCDefault.clone());
        }

        return simplePLCList;
    }
}
