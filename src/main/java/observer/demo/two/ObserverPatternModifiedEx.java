package observer.demo.two;

import java.util.ArrayList;
import java.util.List;

interface IObserver {
    void update(int value);
}

interface ISubject {
    void notifyObservers(int value);
    void register(IObserver observer);
    void unregister(IObserver observer);
}

class Observer1 implements IObserver {
    public void update(int value) {
        System.out.println("Observer1: value in Subject is now: " + value);
    }
}

class Observer2 implements IObserver {
    public void update(int value) {
        System.out.println("Observer2: observers -> myValue is changed in Subject to: " + value);
    }
}

class Subject implements ISubject {
    private int value;
    private List<IObserver> observerList = new ArrayList<>();

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
        this.notifyObservers(value);
    }

    @Override
    public void notifyObservers(int value) {
        for (int i=0; i<observerList.size(); i++) {
            observerList.get(i).update(value);
        }
    }

    @Override
    public void register(IObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void unregister(IObserver observer) {
        observerList.remove(observer);
    }
}

public class ObserverPatternModifiedEx {
    public static void main(String[] args) {
        System.out.println("*** Modified Observer Pattern Demo ***\n");
        Subject subject = new Subject();
        Observer1 observer1 = new Observer1();
        Observer2 observer2 = new Observer2();
        subject.register(observer1);
        subject.register(observer2);
        subject.setValue(25);
        subject.setValue(5);

        //unregister ob1 only
        subject.unregister(observer1);
        //Now only observer2 will observer the change
        subject.setValue(100);
    }
}
