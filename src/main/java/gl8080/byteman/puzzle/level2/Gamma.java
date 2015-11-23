package gl8080.byteman.puzzle.level2;

public class Gamma implements MyInterface {

    @Override
    public String process() {
        System.out.println("Gamma.process()");
        return "gamma";
    }

}
