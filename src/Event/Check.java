package src.Event;
import src.character.Chick;
import src.character.Obstruc;

public class Check { 
    public static boolean checkHit(Chick p, Obstruc ob) {
        return (p.x < ob.x + ob.width ) && ( p.x + p.width > ob.x ) && ( p.y < ob.y + ob.height )&& (p.y + p.height > ob.y);
    }
}
