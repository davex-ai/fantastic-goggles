package Show;

public class GenericMain {
    public static void main(String[] args) {

        Generic<Integer> Gj = new Generic<>();
        Generic<String> info = new Generic<>();

        Gj.setProduct(1000);
        info.setProduct("A Pimp Named SlickBack");


        System.out.println(info.getProduct());
    }
}

