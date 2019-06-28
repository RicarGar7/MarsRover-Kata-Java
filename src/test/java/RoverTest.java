import org.junit.Assert;
import org.junit.Test;

public class RoverTest {

    @Test
    public void roverShouldInitializeCorrectly() {
        Rover rover = new Rover();

        Assert.assertEquals(new Position(0,0).toString(),rover.getPosition().toString());
    }

    private Rover getRoverOnCenterFacingNorth() {
        return new Rover();
    }

    private Rover getRoverOnCenterFacingSouth() {
        return new Rover(new Position(0,0),new Orientation(CardinalPoint.SOUTH));
    }

    private Rover getRoverOnCenterFacingEast() {
        return new Rover(new Position(0,0),new Orientation(CardinalPoint.EAST));
    }

    private Rover getRoverOnCenterFacingWest() {
        return new Rover(new Position(0,0),new Orientation(CardinalPoint.WEST));
    }


}
