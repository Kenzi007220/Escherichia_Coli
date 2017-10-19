package bacteria;

import lombok.extern.log4j.Log4j;
import org.junit.Assert;
import org.junit.Test;

@Log4j
public class CoordinateTest {

  @Test
  public void createCoordinate() {
    Coordinate coordinate = new Coordinate(1, 1);
  }

  @Test
  public void getCoordinate() {
    Coordinate coordinate = new Coordinate(1, 1);
    Assert.assertNotNull(coordinate);
  }

  
}
