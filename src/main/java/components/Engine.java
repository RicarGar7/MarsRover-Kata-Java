package components;

import machines.Machine;
import machines.situation.Position;

public class Engine implements Component {
    private Machine machine;

    public Engine(Machine machine) {
        this.machine = machine;
        this.machine.addComponent(this);
    }

    public void update() {
        char instruction = this.machine.getInstruction();
        Position actualMachinePosition = this.machine.getPosition();
        if (instruction == 'F')
            this.machine.setPosition(new Position(actualMachinePosition.getxAxis(), actualMachinePosition.getyAxis() + 1));
        if (instruction == 'B')
            this.machine.setPosition(new Position(actualMachinePosition.getxAxis(), actualMachinePosition.getyAxis() + 1));
    }
}
