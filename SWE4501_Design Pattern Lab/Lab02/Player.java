public abstract class Player{

    final void Play(){
        WarmUp();
        Strategize();
        Execute();
        Rest();
    }

    final void WarmUp() {
        System.out.println("Exercise");
    }

    abstract void Strategize();

    abstract void Execute();

    void Rest(){
        System.out.println("Take some Rest");
    }
}


class Footballer extends Player{
    @Override
    void Strategize(){
        System.out.println("Strategize Football Formation");
    }

    @Override
    void Execute(){
        System.out.println("Execute Football Formation");
    }

    @Override
    void Rest(){
        System.out.println("Take a bit more rest than usual");
    }
}


class Cricketer extends Player{
    @Override
    void Strategize(){
        System.out.println("Strategize Powerplay");
    }

    @Override
    void Execute(){
        System.out.println("Execute Powerplay Plan");
    }
}