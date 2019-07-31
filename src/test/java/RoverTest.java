import components.Cpu;
import components.Engine;
import components.Gps;
import components.Sensor;
import machines.Rover;
import machines.situation.CardinalPoint;
import machines.situation.Orientation;
import machines.situation.Position;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class RoverTest {
    Rover rover;
    Cpu cpu;
    Gps gps;
    Sensor sensor;
    Engine engine;

    @Before
    public void initializeRoverComponents() {
        rover = getRoverOnCenterFacingNorth();
        cpu = new Cpu(rover);
        gps = new Gps(rover);
        sensor = new Sensor(rover);
        engine = new Engine(rover);
    }

    @Test
    public void roverShouldInitializeCorrectly() {
        Assert.assertEquals(new Rover(new Position(0, 0), new Orientation(CardinalPoint.NORTH)).toString(), rover.toString());
    }

    @Test
    public void roverShouldMoveForward() {
        rover.execute("F".toCharArray());

        Assert.assertEquals(new Position(0, 1).toString(), rover.getPosition().toString());
    }

    @Test
    public void roverShouldMoveBackwards() {
        rover.execute("B".toCharArray());

        Assert.assertEquals(new Position(0, -1).toString(), rover.getPosition().toString());
    }

    @Test
    public void roverShouldTurnAndChangeHimOrientation() {
        Rover otherRover = getRoverOnCenterFacingWest();
        Gps gps = new Gps(otherRover);

        otherRover.execute("R".toCharArray());

        Assert.assertEquals(new Orientation(CardinalPoint.NORTH).toString(), otherRover.getOrientation().toString());
    }

    @Test
    public void roverShouldMoveOnTheCorrectPositionWhenItTurns() {
        rover.execute("FRFLBR".toCharArray());

        Assert.assertEquals(new Rover(new Position(1, 0), new Orientation(CardinalPoint.EAST)).toString(), rover.toString());
    }

    @Test
    public void  roverShouldDetectPosibleObstaclesOnTheNextPositionBeforeHeMoves() {
        sensor.AddObstacle(new Position(0,1));

        rover.execute("F".toCharArray());

        Assert.assertEquals(new Rover(new Position(0, 0), new Orientation(CardinalPoint.NORTH)).toString(), rover.toString());
    }

    private Rover getRoverOnCenterFacingNorth() {
        return new Rover();
    }

    private Rover getRoverOnCenterFacingWest() {
        return new Rover(new Position(0, 0), new Orientation(CardinalPoint.WEST));
    }
}
