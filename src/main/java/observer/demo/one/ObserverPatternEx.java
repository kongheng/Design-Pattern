package observer.demo.one;

import java.util.ArrayList;
import java.util.List;

class Observer {
    public void update(int flag) {
        System.out.println("flag value changed to " + flag + " in Subject");
    }
}

interface ISubject {
    void register(Observer observer);
    void unregister(Observer observer);
    void notifyObserver(int flag);
}

class Subject implements ISubject {
    private int flag;
    List<Observer> observerList = new ArrayList<>();
    public int getFlag() { return flag; }
    public void setFlag(int flag) {
        this.flag = flag;
        notifyObserver(flag);
    }

    @Override
    public void register(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver(int flag) {
        for (int i=0; i<observerList.size(); i++) {
            observerList.get(i).update(flag);
        }
    }
}

public class ObserverPatternEx {
    public static void main(String[] args) {
        System.out.println("*** Observer Pattern Demo ***\n");
        Observer observer = new Observer();
        Subject subject = new Subject();
        subject.register(observer);
        System.out.println("Setting Flag = 5");
        subject.setFlag(5);
        System.out.println("Setting Flag = 25");
        subject.setFlag(25);
        subject.unregister(observer);
        // No notification this time to observer. Since it is unregistered.
        System.out.println("Setting Flag = 50");
        subject.setFlag(50);
    }
}
