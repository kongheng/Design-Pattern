package observer.practice;

import java.util.ArrayList;
import java.util.List;

interface IObserver {
    void update(int value);
}

interface ISubject {
    void register(IObserver observer);
    void unregister(IObserver observer);
    void notifyObservers(int value);
}

class Observer1 implements IObserver {
    @Override
    public void update(int value) {
        System.out.println("Observer1 = " + value);
    }
}

class Observer2 implements IObserver {
    @Override
    public void update(int value) {
        System.out.println("Observer2 = " + value);
    }
}

class Subject1 implements ISubject {
    private int value;
    private List<IObserver> observerList = new ArrayList<>();
    public int getValue() { return value; }
    public void setValue(int value) {
        this.value = value;
        this.notifyObservers(value);
    }
    @Override
    public void register(IObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void unregister(IObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers(int value) {
        for (int i=0; i<observerList.size(); i++) {
            observerList.get(i).update(value);
        }
    }
}

class Subject2 implements ISubject {
    private int grade;
    private List<IObserver> observerList = new ArrayList<>();
    public int getGrade() { return grade; }
    public void setGrade(int grade) {
        this.grade = grade;
        this.notifyObservers(grade);
    }
    @Override
    public void register(IObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void unregister(IObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers(int value) {
        for (int i=0; i<observerList.size(); i++) {
            System.out.println("Observer2 = " + value);
        }
    }
}

public class ObserverPatternAssignment {
    public static void main(String[] args) {
        Subject1 subject1 = new Subject1();
        Subject2 subject2 = new Subject2();
        Observer1 observer1 = new Observer1();
        Observer2 observer2 = new Observer2();
        subject1.register(observer1);
        subject2.register(observer1);
        subject1.register(observer2);
        subject1.setValue(5);
        subject2.setGrade(15);
    }
}
