import java.lang.StringBuilder;

public class Shell {

    public static void main(String[] args) {
        System.out.println("hello! :3");
        StringBuilder sb = new StringBuilder();
        sb.append("Some die roll tests...\n");
        sb.append("===D4\n");
        for (int i = 0; i < 5; i++) {
            sb.append(Die.roll(4) + "\n");
        }
        sb.append("===2D20\n");
        for (int i = 0; i < 100; i++) {
            sb.append(Die.roll(20, 20) + "\n");
        }
        System.out.println(sb);
        System.out.println(new Input("test/players.json"));
    }

}