package facade.demo.one.facade.pattern.demo;

import facade.demo.one.robotparts.RobotBody;
import facade.demo.one.robotparts.RobotColor;
import facade.demo.one.robotparts.RobotMetal;

class RobotFacade {
    RobotColor robotColor;
    RobotMetal robotMetal;
    RobotBody robotBody;
    public RobotFacade() {
        robotColor = new RobotColor();
        robotMetal = new RobotMetal();
        robotBody = new RobotBody();
    }
    public void constructRobot(String color, String metal) {
        System.out.println("\nCreation of the Robot start");
        robotColor.setColor(color);
        robotMetal.setMetal(metal);
        robotBody.createBody();
        System.out.println("\nRobot creation end");
        System.out.println();
    }
}

public class FacadePatternEx {
    public static void main(String[] args) {
        System.out.println("***Facade Pattern Demo***");
        RobotFacade rf1 = new RobotFacade();
        rf1.constructRobot("Green", "Iron");
        RobotFacade rf2 = new RobotFacade();
        rf2.constructRobot("Blue", "Steel");
    }
}
