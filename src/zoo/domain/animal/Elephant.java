package zoo.domain.animal;

import zoo.domain.ability.Sprayable;
import zoo.domain.food.Food;

// 코끼리
public class Elephant extends Mammal implements Sprayable {

    public Elephant(String name, int age) {
        super(name, age);
    }

    @Override
    public String getType() {
        return "코끼리";
    }

    @Override
    public String makeSound() {
        return "뿌우!";
    }

    @Override
    public String sprayWater() {
        return getName() + "(이)가 물을 이곳저곳 뿌렸습니다!";
    }

    @Override
    public String specialAbility() {
        happy(20);
        return sprayWater() + " 행복도가 크게 증가했습니다.";
    }

    @Override
    public String specialAbilityName() {
        return "물 뿌리기 능력";
    }

    @Override
    public Food preferredFood() {
        return Food.PLANT;
    }
}

