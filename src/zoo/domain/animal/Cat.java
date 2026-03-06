package zoo.domain.animal;

// 고양이
public class Cat extends Mammal{

    public Cat(String name, int age) {
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

    @Override
    public String specialAbility() {
        return "";
    }

}
