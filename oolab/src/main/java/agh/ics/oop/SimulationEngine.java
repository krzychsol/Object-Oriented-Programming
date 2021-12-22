package agh.ics.oop;
import agh.ics.oop.gui.App;
import agh.ics.oop.gui.IGridPaneChangeObserver;
import org.junit.platform.commons.util.Preconditions;
import java.util.ArrayList;

public class SimulationEngine implements IEngine,Runnable{

    private MoveDirection[] moves;
    private final ArrayList<Animal> animals = new ArrayList<>();
    private final int moveDelay = 300;
    private IGridPaneChangeObserver observer;

    public SimulationEngine(MoveDirection[] movesList,IWorldMap map,Vector2d[] initialPositions,IGridPaneChangeObserver mapUpdater){
        this.observer = mapUpdater;
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
        for (MoveDirection m : moves) {
            try{
                Thread.sleep(moveDelay);
            }catch(Exception e){
                e.printStackTrace();
            }
            animals.get(curAnimal % numOfAnimals).move(m);
            curAnimal += 1;
            observer.gridPaneChanged();
        }
    }
}
