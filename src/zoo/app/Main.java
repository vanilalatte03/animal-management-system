package zoo.app;

import org.w3c.dom.ls.LSOutput;
import zoo.domain.animal.*;
import zoo.service.Zoo;

import java.util.Scanner;

public class Main {
    public static final Scanner SCANNER = new Scanner(System.in);
    // 동물 저장,조회 전역 변수
    public static final Zoo ZOO = new Zoo();

    // 프로그램 시작
    public static void main(String[] args) {
        boolean running = true;

        while (running){
            printMenu();
            int select = readInt("메뉴를 선택하세요: ");

            switch (select){
                case 1: // 동물 등록
                    registerAnimal();
                    break;
                case 2: // 동물 목록 조회
                    printAnimalList();
                    break;
                case 3: // 동물과 놀기
                    playAnimal();
                    break;
                case 4: // 동물 밥 주기
                    feedAnimal();
                    break;
                case 5: // 특별 능력 사용
                    useSpecialAbility();
                    break;
                case 6: // 동물 상태 확인
                    printAnimalStatus();
                    break;
                case 7: // 울음 소리 듣기
                    hearAnimalSound();
                    break;
                case 8: // 종료
                    running = false;
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 메뉴 번호입니다.");
            }
        }
    }


    // 메뉴 출력
    private static void printMenu() {
        System.out.println("=== 동물원 관리 시스템 ===\n" +
                "1. 동물 등록\n" +
                "2. 동물 목록 보기\n" +
                "3. 동물과 놀기\n" +
                "4. 먹이주기\n" +
                "5. 특별 능력 사용\n" +
                "6. 동물 상태 확인\n" +
                "7. 울음소리 듣기\n" +
                "8. 종료");
    }

    // 동물 등록
    private static void registerAnimal() {
        String name = readString("동물 이름을 입력하세요: ");
        int age = readInt("동물 나이를 입력하세요: ");

        if (age < 0) {
            System.out.println("나이는 0보다 작을 수 없습니다.");
            return;
        }

        printAnimalType();
        int type = readInt("동물 종류를 선택하세요: ");
        if (type < 1 || type > 8) {
            System.out.println("해당하는 동물 종류가 없습니다.");
            return;
        }

        // 타입 확인 후 추가
        Animal animal = createAnimal(type, name, age);
        ZOO.addAnimal(animal);
        System.out.printf("%s(%s, %d살)(이)가 등록되었습니다.\n", animal.getName(), animal.getType(), animal.getAge());
    }

    // 동물 목록 조회
    private static void printAnimalList() {
        // 목록이 비어있는지 확인
        if(!ZOO.checkAnimal()) {
            System.out.println("등록된 동물이 없습니다.");
            return;
        }

        // 동물 목록 출력
        System.out.println("=== 동물 목록 ===");
        for (int i = 0; i < ZOO.getAnimals().size(); i++){
            Animal animal = ZOO.getAnimalIndex(i);
            System.out.printf("%d. %s(%s, %d살)\n", i+1, animal.getName(), animal.getType(), animal.getAge() );
        }
    }

    // 동물과 놀기
    private static void playAnimal(){
        Animal select = selectAnimal("놀아줄 동물을 선택하세요.");
        if (select == null) {
            return;
        }
        select.play();
        System.out.printf("%s와(과) 놀았습니다. 행복도가 증가했습니다\n", select.getName());
    }

    // 동물 밥 주기
    private static void feedAnimal(){
        Animal select = selectAnimal("먹이를 줄 동물을 선택하세요.");
        if (select == null) {
            return;
        }
        select.feed();
        System.out.printf("%s에게 먹이를 주었습니다. 배고픔이 감소했습니다\n", select.getName());
    }

    // 특별 능력 사용
    private static void useSpecialAbility() {
        Animal select = selectAnimal("특별 능력을 사용할 동물을 선택하세요.");
        if (select == null) {
            return;
        }
        System.out.println(select.specialAbility());
    }

    // 동물 상태 확인
    private static void printAnimalStatus() {
        Animal select = selectAnimal("상태를 확인할 동물을 선택하세요.");
        if (select == null) {
            return;
        }
        System.out.printf(select.getStatus());
    }

    // 울음 소리 듣기
    private static void hearAnimalSound() {
        Animal select = selectAnimal("울음 소리를 들을 동물을 선택하세요.");
        if (select == null) {
            return;
        }
        System.out.printf("%s: %s\n", select.getName(), select.makeSound());
    }

    // 동물을 선택하고 반환
    private static Animal selectAnimal(String msg) {
        // 목록이 비어있는지 확인
        if(!ZOO.checkAnimal()) {
            System.out.println("등록된 동물이 없습니다.");
            return null;
        }

        // 상황에 맞는 메세지 출력
        System.out.println(msg);

        // 동물 목록 출력
        for (int i = 0; i < ZOO.getAnimals().size(); i++){
            Animal animal = ZOO.getAnimalIndex(i);
            System.out.printf("%d. %s(%s, %d살)\n", i+1, animal.getName(), animal.getType(), animal.getAge() );
        }

        // 입력
        int choice = readInt("선택: ");
        Animal select = ZOO.getAnimalIndex(choice - 1);

        if (select == null) {
            System.out.println("잘못된 번호입니다.");
        }
        return select;
    }

    // 동물 종류 선택 메뉴
    private static void printAnimalType(){
        System.out.println("=== 동물 종류 ===\n" +
                "1. 강아지\n" +
                "2. 고양이\n" +
                "3. 독수리\n" +
                "4. 펭귄\n" +
                "5. 사자\n" +
                "6. 코끼리\n" +
                "7. 뱀\n" +
                "8. 거북이");
    }

    // 동물 생성
    public static Animal createAnimal(int type, String name, int age){
        switch (type) {
            case 1:
                return new Dog(name, age);
            case 2:
                return new Cat(name, age);
            case 3:
                return new Eagle(name, age);
            case 4:
                return new Penguin(name, age);
            case 5:
                return new Lion(name, age);
            case 6:
                return new Elephant(name, age);
            case 7:
                return new Snake(name, age);
            case 8:
                return new Turtle(name, age);
            default: //여기는 올 일 없음
                return null;
        }
    }


    // 예외 처리: 숫자 입력
    private static int readInt(String msg) {
        while (true) {
            System.out.print(msg);
            String input = SCANNER.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e){
                System.out.println("숫자를 입력하세요.");
            }
        }
    }

    // 예외 처리: 빈 칸 방지
    private static String readString(String msg) {
        while (true) {
            System.out.print(msg);
            String input = SCANNER.nextLine().trim();
            if (!input.isEmpty()){
                return input;
            }
            System.out.println("값이 비어있습니다.");
        }
    }
}