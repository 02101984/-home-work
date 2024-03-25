package person;

import behavior.CoordXY;

public class Crossbowman extends ShooterBase {

    private static final int HEALTH = 800;
    private static final int POWER = 35;     //    сила
    private static final int AGILITY = 20;    //    ловкость
    private static final int DEFENCE = 5;    //    защита: 0 - нет,
    private static final int DISTANCE = 16;
    private static final int ARROWS = 12;
    private static final int EFFECTIVE_DISTANCE = 3;



    public Crossbowman(String name, CoordXY pos) {
        super(name, 3, HEALTH, POWER, AGILITY, DEFENCE, DISTANCE, ARROWS, EFFECTIVE_DISTANCE, pos);
    }

    @Override
    public String toString() {
        return String.format("[Арбалетчик] %s, ");
    }

    @Override
    public String getInfo() {
        return "Арбалетчик" + history;
    }


}
