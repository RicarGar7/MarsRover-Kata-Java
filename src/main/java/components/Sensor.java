package components;

import machines.Machine;
import machines.situation.Position;

import java.util.ArrayList;

public class Sensor implements Component {
    private Machine machine;
    private Position nextPosiblePosition;
    private ArrayList<Position> positionsOccupiedByObstacles;

    public Sensor(Machine machine) {
        this.machine = machine;
        this.machine.addComponent(this);
        this.positionsOccupiedByObstacles = new ArrayList<Position>();
    }

    public void update() {
        this.machine.setObstacleDetected(this.detectPosibleObstacles());
    }

    private boolean detectPosibleObstacles() {
        char instruction = this.machine.getInstruction();
        Position actualMachinePosition = this.machine.getPosition();
        int[] axisHelper = this.machine.getAxisHelper();

        if (instruction == 'F') {
            nextPosiblePosition = new Position(actualMachinePosition.getxAxis() + axisHelper[0], actualMachinePosition.getyAxis() + axisHelper[1]);
            if (isObstacleOnNextPosiblePosition(actualMachinePosition)) return true;
        }
        if (instruction == 'B') {
            nextPosiblePosition = new Position(actualMachinePosition.getxAxis() + -axisHelper[0], actualMachinePosition.getyAxis() + -axisHelper[1]);
            if (isObstacleOnNextPosiblePosition(actualMachinePosition)) return true;
        }
        return false;
    }

    private boolean isObstacleOnNextPosiblePosition(Position actualMachinePosition) {
        for (int i = 0; i < this.positionsOccupiedByObstacles.size(); i++) {
            if (nextPosiblePosition.toString().equals(this.positionsOccupiedByObstacles.get(i).toString())) {
                System.out.println("Obstacle on " + nextPosiblePosition.toString() + "rover stays on actual position (" + actualMachinePosition.toString() + ") and abort the sequence");
                return true;
            }
        }
        return false;
    }

    public void AddObstacle(Position position) {
        this.positionsOccupiedByObstacles.add(position);
    }
}
