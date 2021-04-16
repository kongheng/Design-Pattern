package template_method.demo.one.engineering.papers;

public abstract class BasicEngineering {
    public void papers() {
        math();
        softSkills();
        specialPaper();
    }
    private void math() {
        System.out.println("Mathematics");
    }
    private void softSkills() {
        System.out.println("SoftSkills");
    }
    public abstract void specialPaper();
}
