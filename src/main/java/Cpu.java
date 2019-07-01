public class Cpu implements Component{
    private Machine machine;

    public Cpu(Machine machine) {
        this.machine = machine;
        this.machine.addComponent(this);
    }

    public void update() {
        calculateDirection();

    }

    private void calculateDirection() {
        CardinalPoint actualMachineOrientationCardinalPoint = this.machine.getOrientation().getCardinalPoint();

        switch (actualMachineOrientationCardinalPoint) {
            case NORTH:
                this.machine.setAxisHelper(new int[]{0,1});
                break;
            case EAST:
                this.machine.setAxisHelper(new int[]{1,0});
                break;
            case SOUTH:
                this.machine.setAxisHelper(new int[]{0,-1});
                break;
            case WEST:
                this.machine.setAxisHelper(new int[]{-1,0});
                break;
        }
    }

}
