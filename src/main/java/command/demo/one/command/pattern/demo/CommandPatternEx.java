package command.demo.one.command.pattern.demo;

interface ICommand {
    void doCommand();
}

class Invoke {
    ICommand command;
    public void executeCommand(ICommand cmd) {
        this.command = cmd;
        command.doCommand();
    }
}

class MyRedoCommand implements ICommand {
    private Receiver receiver;
    MyRedoCommand(Receiver recv) {
        receiver = recv;
    }
    @Override
    public void doCommand() {
        receiver.performRedo();
    }
}

class MyUndoCommand implements ICommand {
    private Receiver receiver;
    MyUndoCommand(Receiver recv) {
        receiver = recv;
    }
    @Override
    public void doCommand() {
        receiver.performUndo();
    }
}

class Receiver {
    public void performUndo() {
        System.out.println("Executing - MyUnDoCommand");
    }
    public void performRedo() {
        System.out.println("Executing - MyRedoCommand");
    }
}

public class CommandPatternEx {
    public static void main(String[] args) {
        System.out.println("***Command Pattern Demo***\n");
        Receiver receiver = new Receiver();
        Invoke invoke = new Invoke();
        MyUndoCommand unCmd = new MyUndoCommand(receiver);
        MyRedoCommand reCmd = new MyRedoCommand(receiver);
        invoke.executeCommand(unCmd);
        invoke.executeCommand(reCmd);
    }
}
