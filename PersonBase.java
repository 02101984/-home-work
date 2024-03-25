package person;

import behavior.ActionInterface;
import  behavior.CoordXY;

import java.util.ArrayList;
import java.util.Random;

// База для персонажей.

public abstract class PersonBase implements ActionInterface {
    protected static Random rnd;
    static  {
        rnd = new Random();
    }

    protected String name;
    public int priority;    //     приоритет хода
    protected int health;      //    здоровье
    protected final int maxHealth;
    protected final int power;
    protected final int agility;     //  ловкость
    protected final int defence;
    protected int distance;         //    дистанция воздействия на другой объект.

    protected CoordXY position;     //     перемещение

   protected PersonBase(String name, int priority, int health, int power, int agility, int defence, int distance, CoordXY pos)
   {
        this.name = name;
        this.priority = priority;
        this.health = getRound(health, 10);
        this.maxHealth = this.health;
        this.power = getRound(power, 10);
        this.agility = getRound(agility, 10);
        this.defence = defence;
        this.distance = distance;
        this.position = pos;

   }

//   public int getHealth() {
//
//       return health;
//   }

//    возвращает значение со случайной погрешностью в +-percent%

   protected int getRound(int origin, int percent)
   {
       if (percent > origin)
           return origin;
       int n = (origin * percent) / 100;
       return origin + (rnd.nextInt(0, n * 2+1)- n);
   }

//Задаёт местоположение персонажа

   public void setPosition(int x, int y)
   {

       position.setXY(x, y);
   }
   public CoordXY getPosition() {

      return position;
   }

    //  Лечение персонажа
   public void healed(int health) {

      this.health = Math.min(this.health +health, this.maxHealth);
   }


// персонаж принимает урон
   public int getDamage(int damage)
   {
       boolean probability = (this.agility/2) >= rnd.nextInt(100);
       if (probability) {
           return 0;
       }

       int loss = damage - (this.defence * damage) / 100;
       loss = Math.min(loss, this.health);
       this.health -= loss;
       {
           return loss;
       }

   public PersonBase findNearestPerson(ArrayList<PersonBase> persons)
   {
        PersonBase target = null;
        float minDistance = Float.MAX_VALUE;

        for (PersonBase p : persons)
        {
            if (p.health > 0)
            {
                float dist = position.distanceTo(p.position);
                if (dist < minDistance)
                {
                    minDistance = dist;
                    target = p;
                }
            }
        }
        return target;
    }

}