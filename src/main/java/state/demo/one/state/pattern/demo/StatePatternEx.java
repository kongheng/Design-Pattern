package state.demo.one.state.pattern.demo;

abstract class RemoteControl {
    public abstract void pressSwitch(TV context);
}

class TV {
    private RemoteControl state;
    public void setState(RemoteControl state) {
        this.state = state;
    }
    public TV(RemoteControl state) {
        this.state = state;
    }
    public void pressButton() {
        state.pressSwitch(this);
    }
}

class On extends RemoteControl {
    @Override
    public void pressSwitch(TV context) {
        System.out.println("I am already On. Going to be Off now.");
        context.setState(new Off());
    }
}

class Off extends RemoteControl {
    @Override
    public void pressSwitch(TV context) {
        System.out.println("I am Off. Going to be On now");
        context.setState(new On());
    }
}

public class StatePatternEx {
    public static void main(String[] args) {
        System.out.println("***State Patter Demo***");
        Off initialState = new Off();
        TV tv = new TV(initialState);
        tv.pressButton();
        tv.pressButton();
    }
}
