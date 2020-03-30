package infrastructure;


import infrastructure.state.State;

public class SimplePLC implements Cloneable {

    private State state;

    public SimplePLC(){
        this.state = State.UNKNOWN;
    }

    public SimplePLC(State state){
        this.state= state;
    }

    private SimplePLC(SimplePLC simplePLC){
        this.state = simplePLC.getState();
    }

    public SimplePLC clone(){
        return new SimplePLC(this);
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState(){
        return this.state;
    }
}
