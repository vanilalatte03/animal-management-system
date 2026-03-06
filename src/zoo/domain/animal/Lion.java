package zoo.domain.animal;

import zoo.domain.ability.Scratchable;
import zoo.domain.food.Food;

// 사자
public class Lion extends Mammal implements Scratchable {

    public Lion(String name, int age) {
        super(name, age);
    }

    @Override
    public String getType() {
        return "사자";
    }

    @Override
    public String makeSound() {
        return "으르렁!";
    }

    @Override
    public String scratch() {
        return getName() + "(이)가 물건을 마구 긁었습니다!";
    }


    @Override
    public String specialAbility() {
        happy(20);
        return scratch() + " 행복도가 크게 증가했습니다.";
    }

    @Override
    public String specialAbilityName() {
        return "긁기 능력";
    }

    @Override
    public Food preferredFood() {
        return Food.MEAT;
    }
}
