package bacteria;

import lombok.extern.log4j.Log4j;
import org.junit.Assert;
import org.junit.Test;

@Log4j
public class WorldTest {

  private World world = new World();

  @Test
  public void aNewWorldDontHasCellsTest() {
    World worldTest = new World();
    Assert.assertEquals(0, worldTest.getLiveCellCoordinates().size());
  }

  @Test
  public void cellsAddedToGameMaintainedTest() {
    Coordinates liveCellsCoordinates = new Coordinates(2, 3);
    world.addLiveCellsAt(liveCellsCoordinates);
    Assert.assertTrue(world.getLiveCellCoordinates().contains(liveCellsCoordinates));
  }

  @Test
  public void aloneCellDieAfterFirstGenerationTest() {

    Coordinates liveCellsCoordinates = new Coordinates(2, 3);
    world.addLiveCellsAt(liveCellsCoordinates);
    Assert.assertEquals(0,
        world.countOfLiveBacteriasInside(liveCellsCoordinates.neighborCoordinates()));
    world.startGeneration();
    Assert.assertFalse(world.getLiveCellCoordinates().contains(liveCellsCoordinates));


  }

}
