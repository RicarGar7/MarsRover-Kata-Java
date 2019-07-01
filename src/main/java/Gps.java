public class Gps implements Component {
    private Machine machine;

    public Gps(Machine machine) {
        this.machine = machine;
        this.machine.addComponent(this);
    }

    public void update() {
        Orientation actualMachineOrientation = this.machine.getOrientation();
        this.machine.setOrientation(this.getNextOrientation());
    }

    private Orientation getNextOrientation() {
        char instruction = this.machine.getInstruction();
        String actualMachineOrientation = this.machine.getOrientation().getCardinalPoint().toString();
        int actualCardinalPointIndex = CardinalPoint.valueOf(actualMachineOrientation).ordinal();
        int nextCardinalPointIndex = CardinalPoint.valueOf(actualMachineOrientation).ordinal() + 1;
        int prevCardinalPointIndex = CardinalPoint.valueOf(actualMachineOrientation).ordinal() - 1;
        int lastCardinalPointIndex = CardinalPoint.values().length - 1;

        if (instruction == 'L') {
            if (actualCardinalPointIndex == 0)
                return new Orientation(CardinalPoint.values()[lastCardinalPointIndex]);
            return new Orientation(CardinalPoint.values()[prevCardinalPointIndex]);
        } else if (instruction == 'R') {
            if (actualCardinalPointIndex == lastCardinalPointIndex)
                return new Orientation(CardinalPoint.values()[0]);
            return new Orientation(CardinalPoint.values()[nextCardinalPointIndex]);
        }
        return this.machine.getOrientation();
    }
}
