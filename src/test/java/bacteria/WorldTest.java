package bacteria;

import org.junit.Assert;
import org.junit.Test;


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
  public void aloneBacteriaDieAfterFirstGenerationTest() {

    Coordinates liveCellsCoordinates = new Coordinates(2, 3);
    world.addLiveCellsAt(liveCellsCoordinates);
    Assert.assertEquals(0,
        world.countOfLiveBacteriasInside(liveCellsCoordinates.neighborCoordinates()));
    world.startGeneration();
    Assert.assertFalse(world.getLiveCellCoordinates().contains(liveCellsCoordinates));

  }

  @Test
  public void bacteriaWithTwoNeighborsSurvivesFirstGenerationTest() {

    Coordinates liveCellsCoordinates = new Coordinates(2, 3);
    world.addLiveCellsAt(liveCellsCoordinates);
    world.addLiveCellsAt(new Coordinates(2, 2));
    world.addLiveCellsAt(new Coordinates(2, 4));
    Assert.assertEquals(8, liveCellsCoordinates.neighborCoordinates().size());
    Assert.assertEquals(2,
        world.countOfLiveBacteriasInside(liveCellsCoordinates.neighborCoordinates()));
    world.startGeneration();
    Assert.assertTrue(world.getLiveCellCoordinates().contains(liveCellsCoordinates));

  }

  @Test
  public void bacteriaWithThreeNeighborsSurvivesFirstGenerationTest() {

    Coordinates liveBacteriaCoordinates = new Coordinates(2, 3);
    world.addLiveCellsAt(liveBacteriaCoordinates);
    world.addLiveCellsAt(new Coordinates(2, 2));
    world.addLiveCellsAt(new Coordinates(2, 4));
    world.addLiveCellsAt(new Coordinates(1, 4));
    Assert.assertEquals(8, liveBacteriaCoordinates.neighborCoordinates().size());
    Assert.assertEquals(3,
        world.countOfLiveBacteriasInside(liveBacteriaCoordinates.neighborCoordinates()));
    world.startGeneration();
    Assert.assertTrue(world.getLiveCellCoordinates().contains(liveBacteriaCoordinates));

  }

  @Test
  public void deadBacteriaWithThreeLiveNeighborsComesToLifeTest() {

    Coordinates deadBacteriaCoordinates = new Coordinates(2, 3);

    world.addLiveCellsAt(new Coordinates(2, 2));
    world.addLiveCellsAt(new Coordinates(2, 4));
    world.addLiveCellsAt(new Coordinates(1, 4));

    Assert.assertEquals(3,
        world.countOfLiveBacteriasInside(deadBacteriaCoordinates.neighborCoordinates()));
    world.startGeneration();
    Assert.assertTrue(world.getLiveCellCoordinates().contains(deadBacteriaCoordinates));

  }


}
