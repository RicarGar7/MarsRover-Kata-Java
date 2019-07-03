package components;


import machines.Machine;
import machines.situation.CardinalPoint;

public class Cpu implements Component {
    private Machine machine;

    public Cpu(Machine machine) {
        this.machine = machine;
        this.machine.addComponent(this);
    }

    public void update() {
        this.machine.setAxisHelper(calculateDirection());
    }

    private int[] calculateDirection() {
        CardinalPoint actualMachineOrientation = this.machine.getOrientation().getCardinalPoint();

        switch (actualMachineOrientation) {
            case NORTH:
                return new int[]{0, 1};
            case EAST:
                return new int[]{1, 0};
            case SOUTH:
                return new int[]{0, -1};
            case WEST:
                return new int[]{-1, 0};
            default:
                return new int[]{0, 0};
        }
    }
}
