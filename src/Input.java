import org.json.JSONObject;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class Input {

    public static Pair<List<Creature>, List<Creature>> read_from_file(String pathname) {
        String content = null;
        try {
            File file = new File(pathname);
            content = FileUtils.readFileToString(file, "utf-8");
        } catch (IOException e) {
            System.out.println("Error while reading JSON creature file!");
            e.printStackTrace();
            System.exit(1);
        }
        JSONObject input = new JSONObject(content);
        List<Creature> players = Arrays.asList((Creature[]) input.get("players"));
        List<Creature> enemies = Arrays.asList((Creature[]) input.get("enemies"));
        return new Pair<>(players, enemies);
    }

}
