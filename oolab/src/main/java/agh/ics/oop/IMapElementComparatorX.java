package agh.ics.oop;
import java.util.Comparator;

public class IMapElementComparatorX implements Comparator {
    @Override
    public int compare(Object t1, Object t2) {
        if(t1 == t2) return 0;
        int t1x = ((Vector2d) t1).x;
        int t2x = ((Vector2d) t2).x;
        int t1y = ((Vector2d) t1).y;
        int t2y = ((Vector2d) t2).y;

        if (t1x > t2x) return 1;
        else if (t1x < t2x) return -1;
        else if (t1y > t2y) return 1;
        else if (t1y < t2y) return -1;
        else return 0;
    }
}
