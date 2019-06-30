import java.util.ArrayList;

public class Rover implements Machine {
    private ArrayList<Component> components;
    private Thread thread;

    private char instuction = ' ';

    private Orientation orientation;
    private Position position;

    public Rover(Position position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
        this.components = new ArrayList<Component>();
    }
    public Rover() {
        this.position = new Position(0,0);
        this.orientation = new Orientation(CardinalPoint.NORTH);
        this.components = new ArrayList<Component>();
    }

    public void addComponent(Component component){
        components.add(component);
        notifyComponents();
    }

    public void removeComponent(Component component){
        components.remove(component);
    }

    public void notifyComponents(){
        for(Component component : components){
            component.update();
        }
    }

    public void execute(char[] commands) {
        for(char command : commands){
            this.instuction = command;
            notifyComponents();
        }
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public char getInstruction() {
        return instuction;
    }
}
