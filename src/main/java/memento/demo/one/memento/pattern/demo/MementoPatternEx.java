package memento.demo.one.memento.pattern.demo;

class Memento {
    private String state;
    public Memento(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }
}

class Originator {
    private String state;
    Memento memento;
    public void setState(String state) {
        this.state = state;
        System.out.println("State at present: " + state);
    }
    public Memento originatorMemento() {
        memento = new Memento(state);
        return memento;
    }
    public void revert(Memento memento) {
        System.out.println("Restoring to previous state...");
        state = memento.getState();
        System.out.println("State at present: " + state);
    }
}

class Caretaker {
    private Memento memento;
    public void saveMemento(Memento memento) {
        this.memento = memento;
    }
    public Memento retrieveMemento() {
        return memento;
    }
}

public class MementoPatternEx {
    public static void main(String[] args) {
        System.out.println("***Memento Pattern Demo***");
        Originator originator = new Originator();
        originator.setState("First State");
        Caretaker caretaker = new Caretaker();
        caretaker.saveMemento(originator.originatorMemento());
        originator.setState("Second State");
        originator.revert(caretaker.retrieveMemento());
    }
}
