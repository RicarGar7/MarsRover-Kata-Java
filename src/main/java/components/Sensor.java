package components;

import machines.Machine;
import machines.situation.Position;

public class Sensor implements Component {
    private Machine machine;

    public Sensor(Machine machine) {
        this.machine = machine;
        this.machine.addComponent(this);
    }

    public void update() {
        this.machine.setObstacleDetected(this.detectPosibleObstacles());
    }

    private boolean detectPosibleObstacles() {
        char instruction = this.machine.getInstruction();
        Position actualMachinePosition = this.machine.getPosition();
        int[] axisHelper = this.machine.getAxisHelper();

        if (instruction == 'F') {
            Position nextPosiblePosition = new Position(actualMachinePosition.getxAxis() + axisHelper[0], actualMachinePosition.getyAxis() + axisHelper[1]);
            // condicion, comprobar si nextPosiblePosition esta ya ocupada en la posicion de los obstaculos.
        }
        if (instruction == 'B') {
            Position nextPosiblePosition = new Position(actualMachinePosition.getxAxis() + -axisHelper[0], actualMachinePosition.getyAxis() + -axisHelper[1]);
            // condicion, comprobar si nextPosiblePosition esta ya ocupada en la posicion de los obstaculos.
        }
        return false;
    }
}
