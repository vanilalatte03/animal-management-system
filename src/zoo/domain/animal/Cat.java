package zoo.domain.animal;

public class Cat extends Animal{

    protected Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public String getType() {
        return "고양이";
    }

    @Override
    public String makeSound() {
        return "야옹~";
    }

}
