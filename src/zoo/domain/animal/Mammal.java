package zoo.domain.animal;

// 포유류 공통 분류
public abstract class Mammal extends Animal {
    protected Mammal(String name, int age) {
        super(name, age);
    }
}
