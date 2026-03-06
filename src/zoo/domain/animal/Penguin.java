package zoo.domain.animal;

import zoo.domain.ability.Swimmable;

public class Penguin extends Bird implements Swimmable {

    public Penguin(String name, int age) {
        super(name, age);
    }

    @Override
    public String getType() {
        return "펭귄";
    }

    @Override
    public String makeSound() {
        return "꽥꽥!";
    }

    @Override
    public String swim() {
        return getName() + "(이)가 물속을 빠르게 헤엄쳤습니다!";
    }

    @Override
    public String specialAbility() {
        happy(22);
        return swim() + " 행복도가 크게 증가했습니다.";
    }

    @Override
    public String specialAbilityName() {
        return "수영 능력";
    }
}
