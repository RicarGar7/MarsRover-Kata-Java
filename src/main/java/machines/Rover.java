package machines;


import components.Component;
import machines.situation.CardinalPoint;
import machines.situation.Orientation;
import machines.situation.Position;

import java.util.ArrayList;

public class Rover implements Machine {
    private ArrayList<Component> components;

    private char instruction;
    private int[] axisHelper = {0, 0};
    private boolean obstacleDetected = false;

    private Orientation orientation;
    private Position position;



    public Rover(Position position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
        this.components = new ArrayList<Component>();

    }

    public Rover() {
        this.position = new Position(0, 0);
        this.orientation = new Orientation(CardinalPoint.NORTH);
        this.components = new ArrayList<Component>();
    }

    public void execute(char[] commands) {
        for (char command : commands) {
            if(!obstacleDetected) {
                this.instruction = command;
                notifyComponents();
            }
        }
    }
    private void notifyComponents() {
        for (Component component : components) {
            component.update();
        }
    }

    public void addComponent(Component component) {
        components.add(component);
        notifyComponents();
    }
    public void removeComponent(Component component) {
        components.remove(component);
    }

    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }

    public Orientation getOrientation() {
        return orientation;
    }
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public int[] getAxisHelper() {
        return axisHelper;
    }
    public void setAxisHelper(int[] axisHelper) {
        this.axisHelper = axisHelper;
    }

    public boolean isObstacleDetected() {
        return obstacleDetected;
    }
    public void setObstacleDetected(boolean obstacleDetected) {
        this.obstacleDetected = obstacleDetected;
    }

    public char getInstruction() {
        return instruction;
    }

    @Override
    public String toString() {
        return "Rover{" +
                "orientation=" + orientation.toString() +
                ", position=" + position.toString() +
                '}';
    }
}
