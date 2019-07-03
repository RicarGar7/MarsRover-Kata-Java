package components;

import machines.Machine;
import machines.situation.CardinalPoint;
import machines.situation.Orientation;

public class Gps implements Component {
    private Machine machine;

    public Gps(Machine machine) {
        this.machine = machine;
        this.machine.addComponent(this);
    }

    public void update() {
        this.machine.setOrientation(this.getNextOrientation());
    }

    private Orientation getNextOrientation() {
        char instruction = this.machine.getInstruction();

        String actualMachineOrientation = this.machine.getOrientation().getCardinalPoint().toString();

        int nextCardinalPointIndex = CardinalPoint.valueOf(actualMachineOrientation).ordinal() + 1;
        int prevCardinalPointIndex = CardinalPoint.valueOf(actualMachineOrientation).ordinal() - 1;
        int lastCardinalPointIndex = CardinalPoint.values().length - 1;

        if (instruction == 'L') {
            if (isTheFirstCardinalPointOfEnum())
                return new Orientation(CardinalPoint.values()[lastCardinalPointIndex]);
            return new Orientation(CardinalPoint.values()[prevCardinalPointIndex]);
        } else if (instruction == 'R') {
            if (isTheLastCardinalPointOfEnum())
                return new Orientation(CardinalPoint.values()[0]);
            return new Orientation(CardinalPoint.values()[nextCardinalPointIndex]);
        } else
            return this.machine.getOrientation();
    }

    private boolean isTheFirstCardinalPointOfEnum() {
        int actualCardinalPointIndex = CardinalPoint.valueOf(this.machine.getOrientation().getCardinalPoint().toString()).ordinal();
        return actualCardinalPointIndex == 0;
    }

    private boolean isTheLastCardinalPointOfEnum() {
        int actualCardinalPointIndex = CardinalPoint.valueOf(this.machine.getOrientation().getCardinalPoint().toString()).ordinal();
        int lastCardinalPointIndex = CardinalPoint.values().length - 1;
        return actualCardinalPointIndex == lastCardinalPointIndex;
    }
}
