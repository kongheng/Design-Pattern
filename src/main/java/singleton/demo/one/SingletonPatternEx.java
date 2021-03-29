package singleton.demo.one;

class MakeACaptain {
    private static MakeACaptain captain;
    private MakeACaptain() {}
    public static MakeACaptain getCaptain() {
        if (captain == null) {
            captain = new MakeACaptain();
            System.out.println("New Captain selected for our team");
        } else {
            System.out.println("You already have a Captain for you team");
            System.out.println("Send him for the toss.");
        }
        return captain;
    }
}

public class SingletonPatternEx {
    public static void main(String[] args) {
        System.out.println("***  Singleton Pattern Demo ***\n");
        System.out.println("Trying to make a captain for our team");
        MakeACaptain captain1 = MakeACaptain.getCaptain();
        System.out.println("Trying to make another captain for our team");
        MakeACaptain captain2 = MakeACaptain.getCaptain();
        if (captain1 == captain2) {
            System.out.println("captain1 and captain2 are the same instance");
        }
    }
}
