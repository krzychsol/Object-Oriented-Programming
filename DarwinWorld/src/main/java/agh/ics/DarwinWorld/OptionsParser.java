package agh.ics.DarwinWorld;

import agh.ics.DarwinWorld.Math.MoveDirection;

import java.util.Arrays;

public class OptionsParser {
    public MoveDirection[] parse( String[] args) {
        int tab_len = args.length;
        MoveDirection[] dirs = new MoveDirection[tab_len];
        int cnt1 = 0;
        for (String a : args) {
            switch (a) {
                case "f", "forward" -> {
                    dirs[cnt1] = MoveDirection.FORWARD;
                    cnt1 += 1;
                }
                case "b", "backward" -> {
                    dirs[cnt1] = MoveDirection.BACKWARD;
                    cnt1 += 1;
                }
                case "r", "right" -> {
                    dirs[cnt1] = MoveDirection.RIGHT;
                    cnt1 += 1;
                }
                case "l", "left" -> {
                    dirs[cnt1] = MoveDirection.LEFT;
                    cnt1 += 1;
                }
                default -> throw new IllegalArgumentException(a + " is not legal move specification");
            }
        }
        return Arrays.copyOfRange(dirs, 0, cnt1);
    }
}
