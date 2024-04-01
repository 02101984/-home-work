package persona;

import behavior.CoordXY;

public class Spearman extends InfantryBase {

        private static final int HEALTH = 1000;
        private static final int POWER = 80;     //    сила
        private static final int AGILITY = 10;    //    ловкость
        private static final int DEFENCE = 12;    //    защита: 0 - нет,
        private static final int DISTANCE = 1;


//    Создание экземпляра Копейщика

    public Spearman(String name, CoordXY pos)
        {
            super(name, 2, HEALTH, POWER, AGILITY, DEFENCE, DISTANCE, pos);

        }

        @Override
        public String toString()
        {
            return String.format("[Пикенёр] %s, life=%d, %s", name, health, position.toString());
        }

        @Override
        public String getInfo() {
            return "Пикенёр" + history;
        }



}
