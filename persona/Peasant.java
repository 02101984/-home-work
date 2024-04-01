package persona;

import behavior.CoordXY;

import java.util.ArrayList;

public class Peasant extends PersonBase {

    private static final int HEALTH = 500;
    private static final int POWER = 30;     //    сила
    private static final int AGILITY = 30;    //    ловкость
    private static final int DEFENCE = 0;    //    защита: 0 - нет,
    private static final int DISTANCE = 1;
    private static final int FULL_BAG = 524;

    private final int bag;          //    сколько стрел имееет с собой.


    public Peasant(String name, CoordXY pos) {
        super(name, 0, HEALTH, POWER, AGILITY, DEFENCE, DISTANCE, pos);
        bag = FULL_BAG;
    }

    /*
    *  Создание экземпляра Крестьянина
    * @param enemies  Список его врагов
     */

    @Override
    public void step(ArrayList<PersonBase> enemies, ArrayList<PersonBase> friends) {
        PersonBase pt = null;
        int min = Integer.MAX_VALUE;
        if (health <= 0)
            return;
        for (PersonBase friend : friends) {
            if (friend instanceof ShooterBase) {
                if (((ShooterBase) friend).getAmmo() < min) {
                    min = ((ShooterBase) friend).getAmmo();
                    pt = friend;
                }
            }
        }
        if (pt != null) {
            ((ShooterBase) pt).setAmmo(min + 1);
        }
    }

    @Override
    public String getInfo() {

        return "Крестьянин";
    }

    @Override
    public String toString() {
        return String.format("[Крестьянин] %s, ❤=%d, \uD83C\uDFF9=%d, %s", name,health, bag, position.toString());
    }



}
