package person;

public class Peasant{
    String name;
    int level;     //уровень: макс. hp, атака
    int hp;
    int maxHp;
    int agility;      //ловкость
    int power;        //сила

    int defence;    //защита: 0 - нет,
    int spirit;     //дух (выше дух - быстрее выздоровление)
    int priority;      //влияет на очередность хода



    
    public void getDamage(int damage)
    {
        hp += (damage-defence);

    }
    public void getHealth(int health)
    {
        hp = Math.min(hp + health, maxHp);
    }
    public boolean isLiving()
    {
        return hp > 0;
    }
    public void regeneration()
    {
        if (hp < maxHp)
            hp += spirit;

    }

    public int work()
    {
       return (power * 2);

    }


}
