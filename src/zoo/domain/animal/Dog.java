package zoo.domain.animal;

import zoo.domain.ability.Biteable;
import zoo.domain.food.Food;

// 강아지
public class Dog extends Mammal implements Biteable {

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
    public String bite() {
        return getName() + "(이)가 물기를 사용했습니다!";
    }

    @Override
    public String specialAbility() {
        happy(18);
        return bite() + " 행복도가 크게 증가했습니다.";
    }

    @Override
    public String specialAbilityName() {
        return "물기 능력";
    }

    @Override
    public Food preferredFood() {
        return Food.MEAT;
    }

}
