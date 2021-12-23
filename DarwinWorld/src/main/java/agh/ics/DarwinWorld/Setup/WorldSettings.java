package agh.ics.DarwinWorld.Setup;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;

public class WorldSettings {

    public final int width;
    public final int height;
    public final int startEnergy;
    public final int moveEnergy;
    public final int plantEnergy;
    public final int jungleRatio;
    public final int numOfAnimals;

    public WorldSettings() throws IllegalArgumentException, IOException, ParseException {
        try( FileReader reader = new FileReader("parameters.json") ){
            Object obj = new JSONParser().parse(reader);
            JSONObject jsonObj = (JSONObject) obj;
            validateJson(jsonObj);

            this.width = ((Number) jsonObj.get("width")).intValue();
            this.height = ((Number) jsonObj.get("height")).intValue();
            this.startEnergy = ((Number) jsonObj.get("startEnergy")).intValue();
            this.moveEnergy = ((Number) jsonObj.get("moveEnergy")).intValue();
            this.plantEnergy = ((Number) jsonObj.get("plantEnergy")).intValue();
            this.jungleRatio = ((Number) jsonObj.get("jungleRatio")).intValue();
            this.numOfAnimals = ((Number) jsonObj.get("numOfAnimals")).intValue();

            this.validateArgs();

        }
    }

    private void validateJson(JSONObject jsonObj) throws IllegalArgumentException{
        checkExistence("width", jsonObj);
        checkExistence("height", jsonObj);
        checkExistence("startEnergy", jsonObj);
        checkExistence("moveEnergy", jsonObj);
        checkExistence("plantEnergy", jsonObj);
        checkExistence("jungleRatio", jsonObj);
        checkExistence("numOfAnimals", jsonObj);
        checkExistence("delay", jsonObj);
    }

    private void checkExistence(String arg, JSONObject jsonObj) throws IllegalArgumentException {
        if (!jsonObj.containsKey(arg))
            throw new IllegalArgumentException(arg + " is not listed in parameters");

    }

    private void validateArgs() throws IllegalArgumentException{
        checkIfEqualOrGreater(width,1,"width");
        checkIfEqualOrGreater(height,1,"height");
        checkIfEqualOrGreater(startEnergy,0,"startEnergy");
        checkIfEqualOrGreater(moveEnergy,0,"moveEnergy");
        checkIfEqualOrGreater(plantEnergy,0,"plantEnergy");

        if (jungleRatio < 0 || jungleRatio > 1)
            throw new IllegalArgumentException(jungleRatio + " is not a legal jungleRatio. jungleRatio has to be number between 0.0 and 1.0");

        if (numOfAnimals < 10 || numOfAnimals > width * height)
            throw new IllegalArgumentException(numOfAnimals + " is not a legal numOfAnimals. " +
                    "numOfAnimals has to be at least 10 number and not greater than width * height.");
    }

    private void checkIfEqualOrGreater(int var, int required, String varName){
        if(var < required)
            throw new IllegalArgumentException(var + " is not a legal " + varName +". "+ varName+" has to be at least " + required);
    }
}
