package test;

import com.pathfinder.Planet;
import com.pathfinder.Robot;
import com.pathfinder.enums.Orientation;
import com.pathfinder.util.RobotCommandUtil;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.awt.Point;



public class PlanetTest {

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Test
    public void whenRobotsPassedReturnResult(){

        Planet mars = new Planet(new Point(5,3));

        Robot robot1 = new Robot(new Point(1,1), Orientation.E,mars);
        RobotCommandUtil.executeInstructions(robot1,"RFRFRFRF");

        Assert.assertEquals("1 1 E",robot1.toString());

        Robot robot2 = new Robot(new Point(3,2), Orientation.N, mars);
        RobotCommandUtil.executeInstructions(robot2,"FRRFLLFFRRFLL");

        Assert.assertEquals("3 3 N",robot2.toString());

        Robot robot3 = new Robot(new Point(0,3), Orientation.W, mars);
        RobotCommandUtil.executeInstructions(robot3,"LLFFFLFLFL");

        Assert.assertEquals("2 3 S",robot3.toString());

    }

    @Test
    public void whenInvalidInstructionThenThrowException(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Instruction not identified");

        Planet mars = new Planet(new Point(5,3));
        Robot robot1 = new Robot(new Point(1,1), Orientation.E,mars);
        RobotCommandUtil.executeInstructions(robot1,"RFRFJFRF");
    }

    @Test
    public void whenInvalidPlanetXThenThrowException(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Point cannot exceed 50 in x or y");
        Planet invalidX = new Planet(new Point(52,30));
    }

    @Test
    public void whenInvalidPlanetYThenThrowException(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Point cannot exceed 50 in x or y");
        Planet invalidX = new Planet(new Point(30,60));
    }
}
