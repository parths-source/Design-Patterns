//Strategy Talkable
interface Talkable{
    void talk();
}
//concrete classes for talking strategy
class NonTalkable implements Talkable{
    @Override
    public void talk(){
        System.out.println("cannot talk");
    }
}
class NormalTalk implements Talkable{
    @Override
    public void talk(){
        System.out.println("Talking");

    }
}

//strategy fly
interface Flyable{
    void fly();
}

//concrete classes for fly strategy
class NoFly implements Flyable{
    @Override
    public void fly(){
        System.out.println("cannot fly");
    }
}
class NormalFly implements Flyable{
    @Override
    public void fly() {
        System.out.println("FLYING");

    }
}
//robot class
class Robot{
    //composition
    private Talkable talking;
    private Flyable flying;
    public Robot(Talkable talking,Flyable flying){
        this.talking=talking;
        this.flying=flying;
    }
    void talk(){
        talking.talk();
    }
    void fly(){
        flying.fly();
    }
    private void projection(){
        System.out.println("normal robot");
    };
}
class CompanionRobot extends Robot{
    //composition
    Talkable talking;
    Flyable flying;
    public CompanionRobot(Talkable talking,Flyable flying){
        super(talking,flying);
    }

    void projection(){
        System.out.println("this is your companion and a friend robot");
    }

}
class WorkingRobot extends Robot{
    Talkable talking;
    Flyable flying;
    public WorkingRobot(Talkable talking,Flyable flying){
        super(talking,flying);
    }

    void projection(){
        System.out.println("this is your work focused robot");
    }

}



public class Strategy {
    static void main(String[] args) {
        Robot me=new CompanionRobot(
                new NormalTalk(),
                new NoFly()
        );
        Robot maithili=new WorkingRobot(
                new NonTalkable(),
                new NormalFly()
        );
        me.talk();
        me.fly();
        System.out.println("----------------");
        maithili.fly();
        maithili.talk();
    }

}
