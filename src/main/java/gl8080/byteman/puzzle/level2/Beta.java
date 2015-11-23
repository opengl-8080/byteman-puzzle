package gl8080.byteman.puzzle.level2;

public class Beta implements MyInterface {

    @Override
    public String process() {
        System.out.println("Beta.process()");
        return "beta";
    }

}
