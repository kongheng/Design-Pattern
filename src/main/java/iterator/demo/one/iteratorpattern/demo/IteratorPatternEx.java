package iterator.demo.one.iteratorpattern.demo;

import iterator.demo.one.aggregate.Arts;
import iterator.demo.one.aggregate.ISubject;
import iterator.demo.one.aggregate.Science;
import iterator.demo.one.iterator.IIterator;

import java.util.ArrayList;
import java.util.List;

public class IteratorPatternEx {
    public static void main(String[] args) {
        System.out.println("***Iterator Pattern Demo***\n");
        List<String> subjects = new ArrayList<>();
        ISubject sc_subject = new Science();
        ISubject ar_subject = new Arts();
        IIterator sc_iterator = sc_subject.createIterator();
        IIterator ar_iterator = ar_subject.createIterator();
        System.out.println("\nScience Subjects: ");
        print(sc_iterator);
        System.out.println("\nArts Subjects: ");
        print(ar_iterator);
        ar_iterator.first();
        sc_iterator.first();
        while (!ar_iterator.isDone()) {
            subjects.add(ar_iterator.next());
        }
        while (!sc_iterator.isDone()) {
            subjects.add(sc_iterator.next());
        }
        System.out.println("\nArrayList Subject: ");
        subjects.stream().forEach(System.out::println);
    }

    private static void print(IIterator iterator) {
        while (!iterator.isDone()) {
            System.out.println(iterator.next());
        }
    }
}
