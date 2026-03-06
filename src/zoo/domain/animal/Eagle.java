package zoo.domain.animal;

import zoo.domain.ability.Flyable;
import zoo.domain.food.Food;

// 독수리
public class Eagle extends Bird implements Flyable {

    public Eagle(String name, int age) {
        super(name, age);
    }

    @Override
    public String getType() {
        return "독수리";
    }

    @Override
    public String makeSound() {
        return "까악까악!";
    }

    @Override
    public String fly() {
        return getName() + "(이)가 하늘을 자유롭게 날았습니다!";
    }

    @Override
    public String specialAbility() {
        happy(24);
        return fly() + " 행복도가 크게 증가했습니다.";
    }

    @Override
    public String specialAbilityName() {
        return "비행 능력";
    }

    @Override
    public Food preferredFood() {
        return Food.FISH;
    }
}
