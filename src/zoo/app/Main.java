package zoo.app;

import zoo.domain.animal.Animal;
import zoo.domain.animal.Cat;
import zoo.domain.animal.Dog;
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
            System.out.print("메뉴를 선택하세요: ");
            int select = SCANNER.nextInt();

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
                case 4:

                    break;
                case 5:

                    break;
                case  6:

                    break;
                case 7: //종료
                    running = false;
                    System.out.println("프로그램을 종료합니다.");
                    break;
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
                "5. 동물 상태 확인\n" +
                "6. 울음소리 듣기\n" +
                "7. 종료");
    }

    // 동물 등록
    private static void registerAnimal() {
        System.out.println("동물 이름을 입력하세요: ");
        String name = SCANNER.next().trim();
        System.out.println("동물 나이를 입력하세요: ");
        int age = SCANNER.nextInt();
        System.out.println("동물 종류를 선택하세요 (1.강아지 2.고양이): ");
        int type = SCANNER.nextInt();

        Animal animal = (type == 1) ? new Dog(name, age) : new Cat(name, age);
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
        System.out.println("놀아줄 동물을 선택하세요.");

        // 목록이 비어있는지 확인
        if(!ZOO.checkAnimal()) {
            System.out.println("등록된 동물이 없습니다.");
            return;
        }

        // 동물 목록 출력
        for (int i = 0; i < ZOO.getAnimals().size(); i++){
            Animal animal = ZOO.getAnimals().get(i);
            System.out.printf("%d. %s(%s, %d살)\n", i+1, animal.getName(), animal.getType(), animal.getAge() );
        }

        // 입력
        int choice = SCANNER.nextInt();
        Animal select = ZOO.getAnimalIndex(choice - 1);

        // 선택한 동물과 놀기
        if (select == null) {
            System.out.println("잘못된 번호입니다.");
        } else {
            select.play();
            System.out.printf("%s와(과) 놀았습니다. 행복도가 증가했습니다\n", select.getName());
        }
    }


}