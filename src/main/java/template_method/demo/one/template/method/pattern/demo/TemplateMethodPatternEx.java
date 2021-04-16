package template_method.demo.one.template.method.pattern.demo;

import template_method.demo.one.engineering.papers.BasicEngineering;
import template_method.demo.one.engineering.papers.ComputerScience;
import template_method.demo.one.engineering.papers.Electronics;

public class TemplateMethodPatternEx {
    public static void main(String[] args) {
        System.out.println("***Template Method Patter Demo***\n");
        BasicEngineering basicEngineering = new ComputerScience();
        System.out.println("Computer Sc Papers: ");
        basicEngineering.papers();
        System.out.println();
        basicEngineering = new Electronics();
        System.out.println("Electronics Papers: ");
        basicEngineering.papers();
    }
}
