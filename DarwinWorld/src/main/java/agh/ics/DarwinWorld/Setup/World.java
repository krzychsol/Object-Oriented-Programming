package agh.ics.DarwinWorld.Setup;

import agh.ics.DarwinWorld.IEngine;
import agh.ics.DarwinWorld.Map.RectangularMap;
import agh.ics.DarwinWorld.Simulation.SimulationEngine;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class World {

    public static void main(String[] args) {
        try{
            WorldSettings parameters = new WorldSettings();
            RectangularMap map = new RectangularMap(parameters);
            IEngine engine = new SimulationEngine (parameters,map);
            engine.run();

        } catch (IllegalArgumentException | IOException | ParseException ex) {
            ex.printStackTrace();
        }
    }

}
