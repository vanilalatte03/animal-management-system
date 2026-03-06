package zoo.domain.animal;

// 강아지
public class Dog extends Mammal{

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public String getType() {
        return "강아지";
    }

    @Override
    public String makeSound() {
        return "멍멍!";
    }

    @Override
    public String specialAbility() {
        return "";
    }
}
