package singleton.demo.two;

class MakeACaptain {
    private static MakeACaptain captain = new MakeACaptain();
    private MakeACaptain() {}
    public static MakeACaptain getCaptain() {
        return captain;
    }
    public void saySth(String msg) {
        System.out.println(msg);
    }
}

public class SingletonPatternEx {
    public static void main(String[] args) {
        MakeACaptain makeACaptain = MakeACaptain.getCaptain();
        makeACaptain.saySth("Hello World!");
    }
}
