package singleton.demo.three;

class MakeACaptain {
    private static MakeACaptain captain;
    private MakeACaptain() {}
    private static class SingletonHelper {
        private static final MakeACaptain captain = new MakeACaptain();
    }
    public static MakeACaptain getCaptain() {
        return SingletonHelper.captain;
    }
    public void saySth(String msg) {
        System.out.println(msg);
    }
}

public class SingletonPatternEx {
    public static void main(String[] args) {
        MakeACaptain.getCaptain().saySth("Hello!");
    }
}
