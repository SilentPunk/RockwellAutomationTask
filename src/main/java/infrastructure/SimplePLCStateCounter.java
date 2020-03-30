package infrastructure;

import infrastructure.state.State;

import java.util.List;

public class SimplePLCStateCounter {

    public static long countState(List<SimplePLC> simplePLCList, State state){
        return simplePLCList
                .stream()
                .map(SimplePLC::getState)
                .filter(simplePLCState -> simplePLCState.equals(state))
                .count();
    }
}
