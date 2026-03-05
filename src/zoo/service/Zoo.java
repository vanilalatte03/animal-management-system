package zoo.service;

import zoo.domain.animal.Animal;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    // 동물 목록
    private final List<Animal> animals = new ArrayList<>();

    // 동물 등록
    public void addAnimal(Animal animal) {
        if(animal != null){
            animals.add(animal);
        }
    }

    // 동물 목록 반환
    public List<Animal> getAnimals() {
        return animals;
    }

    // 목록이 비어있는지 확인
    public boolean checkAnimal(){
        return !animals.isEmpty();
    }

    // 특정 위치의 동물 가져오기
    public Animal getAnimalIndex(int index){
        if (index < 0 || index >= animals.size()){
            return null;
        }
        return animals.get(index);
    }
}
