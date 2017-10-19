package bacteria;

import java.util.HashSet;
import java.util.Set;

public class World {

  private Set<Coordinates> liveCellCoordinatesInWorld = new HashSet<Coordinates>();

  public Set<Coordinates> getLiveCellCoordinates() {
    return liveCellCoordinatesInWorld;
  }

}
