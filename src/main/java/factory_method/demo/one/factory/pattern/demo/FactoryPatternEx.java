package factory_method.demo.one.factory.pattern.demo;

interface IAnimal {
    void speak();
}

class Duck implements IAnimal {
    @Override
    public void speak() {
        System.out.println("Duck says Pack-Pack");
    }
}

class Tiger implements IAnimal {
    @Override
    public void speak() {
        System.out.println("Tiger says Halum-Halum");
    }
}

abstract class IAnimalFactory {
    public abstract IAnimal getAnimalType(String type) throws Exception;
}

class ConcreteFactory extends IAnimalFactory {
    @Override
    public IAnimal getAnimalType(String type) throws Exception {
        switch (type) {
            case "Duck":
                return new Duck();
            case "Tiger":
                return new Tiger();
            default:
                throw new Exception("Animal type: " + type + "cannot be instantiation");
        }
    }
}

public class FactoryPatternEx {
    public static void main(String[] args) throws Exception {
        System.out.println("***Factory Pattern Demo***\n");
        IAnimalFactory animalFactory = new ConcreteFactory();
        IAnimal duckType = animalFactory.getAnimalType("Duck");
        duckType.speak();
        IAnimal tigerType = animalFactory.getAnimalType("Tiger");
        tigerType.speak();
        IAnimal lionType = animalFactory.getAnimalType("Lion");
        lionType.speak();
    }
}
