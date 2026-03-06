package zoo.domain.food;

// 동물 선호 먹이
public enum Food {
    MEAT("육류"),
    FISH("어류"),
    PLANT("식물"),
    NUTS("견과류");

    private final String displayName;

    Food(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
