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
        this.hungry = 40;
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
        happiness = Math.min(100, happiness + 10);
    }

    // 특별 능력 사용 시 행복도 증가
    public void happy(int amount) {
        happiness = Math.min(100, happiness + Math.max(0, amount));
    }

    // 동물 상태 확인
    public String getStatus() {
        return String.format(
                "이름: %s\n종류: %s\n나이: %d살\n배고픔: %d\n행복도: %d\n",
                name, getType(), age, hungry, happiness
        );
    }

    public abstract String getType();

    // 서로 다른 울음소리를 낸다
    public abstract String makeSound();

    // 특별 능력 구현
    public abstract String specialAbility();

    // 특별 능력 이름
    public abstract String specialAbilityName();



}
