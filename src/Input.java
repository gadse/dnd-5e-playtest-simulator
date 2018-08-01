import com.google.gson.GsonBuilder;
import lombok.Data;
import org.apache.commons.io.FileUtils;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

/**
 * This class provides access to the information coded into a configuration/input JSON document.
 * <p>
 *
 * The following attributes are provided with getters and setters:
 * <ul>
 *     <li> {@link Input#players}
 *     <li> {@link Input#enemies}
 * </ul>
 */
@Data
public class Input {

    /**The player list.*/
    private LinkedList<Creature> players;
    /**The enemy list.*/
    private LinkedList<Creature> enemies;

    /**
     * Creates a new Input instance whose attributes "players" and "creatures" contain the information coded in the
     * JSON file with the given pathname.
     * @param pathname The input JSON's pathname.
     */
    Input(String pathname) {
        //TODO: Verification! (E.g. basic stats > 0, non-empty names, valid types, etc.)
        String content = null;
        try {
            File file = new File(pathname);
            content = FileUtils.readFileToString(file, "utf-8");
        } catch (IOException e) {
            System.out.println("Error while reading JSON creature file!");
            e.printStackTrace();
            System.exit(1);
        }
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        Input inputBuffer = gson.fromJson(content, Input.class);
        this.players = new LinkedList<>(inputBuffer.players);
        this.enemies = new LinkedList<>(inputBuffer.enemies);
    }

}
