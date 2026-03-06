package Qwin.oop;

class Football implements  Playable{
    int meat;
    public String play(){
        return "Field Game";
    }

    public static void main(String[] args) {
        Chess playable = new Chess();
        System.out.println(playable.play());
    }
}

class Chess implements  Playable{
    int meat;
    public String play(){
        return "Board Game";
    }
}

public interface Playable {
    int meat = 0;

    default String play(){
        return "play Game";
    }
}
