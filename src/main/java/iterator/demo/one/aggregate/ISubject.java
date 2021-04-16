package iterator.demo.one.aggregate;

import iterator.demo.one.iterator.IIterator;

public interface ISubject {
    IIterator createIterator();
}
