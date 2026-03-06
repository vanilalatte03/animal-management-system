package zoo.domain.animal;

import zoo.domain.ability.Biteable;

// 뱀
public class Snake extends Reptile implements Biteable {

    public Snake(String name, int age) {
        super(name, age);
    }

    @Override
    public String getType() {
        return "뱀";
    }

    @Override
    public String makeSound() {
        return "쉬익~";
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
}
