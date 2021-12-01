package agh.ics.oop;
import java.util.ArrayList;

public class SimulationEngine implements IEngine{

    private final MoveDirection[] moves;
    private final ArrayList<Animal> animals = new ArrayList<>();

    public SimulationEngine(MoveDirection[] movesList,IWorldMap map,Vector2d[] initialPositions){
        this.moves = movesList;
        for(Vector2d pos: initialPositions){
            Animal animal = new Animal(map,pos);
            if(map.place(animal)){
                animals.add(animal);
            }
        }
    }

    @Override
    public void run() {
        int numOfAnimals = animals.size();
        int curAnimal = 0;
        for(MoveDirection m: moves){
            animals.get(curAnimal%numOfAnimals).move(m);
            curAnimal += 1;

        }
        for(Animal a: animals){
            System.out.println(a.curPosition());
        }
    }
}
