package zoo.domain.animal;

public abstract class Animal {
    // 동물은 이름, 나이, 배고픔 수치, 행복도를 가진다
    private final String name;
    private final int age;
    private int hungry;
    private int happiness;

    protected Animal(String name, int age) {
        this.name = name;
        this.age = age;
        this.hungry = 50;
        this.happiness = 50;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHungry() {
        return hungry;
    }

    public int getHappiness() {
        return happiness;
    }

    // 먹이주기: 배고픔 -20
    public void feed() {
        hungry = Math.max(0, hungry - 20);
    }

    // 놀아주기: 행복도 +20
    public void play() {
        happiness = Math.min(100, happiness + 20);
    }

    public abstract String getType();

    // 서로 다른 울음소리를 낸다
    public abstract String makeSound();

}
