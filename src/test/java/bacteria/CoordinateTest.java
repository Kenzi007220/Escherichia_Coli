package bacteria;

import org.junit.Assert;
import org.junit.Test;

public class CoordinateTest {

  @Test
  public void createCoordinateTest() {
    Coordinates coordinates = new Coordinates(1, 1);
  }

  @Test
  public void getCoordinateTest() {
    Coordinates coordinates = new Coordinates(1, 1);
    Assert.assertNotNull(coordinates);
  }

  @Test
  public void getNighborsCoordinatesTest() {
    Coordinates coordinates = new Coordinates(1, 1);
    Assert.assertNotNull(coordinates.getWestNorthCoordinate());
    Assert.assertNotNull(coordinates.getNorthCoordinate());
    Assert.assertNotNull(coordinates.getNorthEastCoordinate());
    Assert.assertNotNull(coordinates.getWestCoordinate());
    Assert.assertNotNull(coordinates.getSouthEastCoordinate());
    Assert.assertNotNull(coordinates.getSouthCoordinate());
    Assert.assertNotNull(coordinates.getSouthWestCoordinate());
  }

}
