package person;

public abstract class PersonBase {
    protected int hp;
    protected int maxHp;
    protected int power;
    protected int maxPower;
    protected int speed;
    protected int agility;
    protected int intellect;


    public void damage(int damage)
    {
        hp += damage;
        if (hp <0)
        {
//            die();
        } else  {
            if (hp > maxHp)
                hp = maxHp;
        }

    }
    public abstract void step();
}