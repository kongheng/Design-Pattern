package iterator.demo.one.aggregate;

import iterator.demo.one.iterator.IIterator;

import java.util.LinkedList;

public class Science implements ISubject {
    private LinkedList<String> subjects;
    public Science() {
        subjects = new LinkedList<>();
        subjects.addLast("Maths");
        subjects.addLast("Comp. Sc.");
        subjects.addLast("Physics");
    }
    @Override
    public IIterator createIterator() {
        return new ScienceIterator(subjects);
    }
    public class ScienceIterator implements IIterator {
        private LinkedList<String> subjects;
        private int position;
        public ScienceIterator(LinkedList<String> subjects) {
            this.subjects = subjects;
            position = 0;
        }

        @Override
        public void first() {
            position = 0;
        }

        @Override
        public String next() {
            return subjects.get(position++);
        }

        @Override
        public boolean isDone() {
            return position >= subjects.size();
        }

        @Override
        public String currentItem() {
            return subjects.get(position);
        }
    }
}
