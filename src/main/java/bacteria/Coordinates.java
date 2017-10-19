package bacteria;

import java.util.HashSet;
import java.util.Set;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Coordinates {

  private final int x;
  private final int y;

  private static final int WEST = -1;
  private static final int EAST = 1;
  private static final int NORTH = -1;
  private static final int SOUTH = 1;
  private static final int SAME = 0;

  public Set<Coordinates> neighborCoordinates() {
    HashSet<Coordinates> neighbors = new HashSet<Coordinates>();
    neighbors.add(getWestNorthCoordinate());
    neighbors.add(getNorthCoordinate());
    neighbors.add(getNorthEastCoordinate());
    neighbors.add(getWestCoordinate());
    neighbors.add(getEastCoordinate());
    neighbors.add(getSouthEastCoordinate());
    neighbors.add(getSouthCoordinate());
    neighbors.add(getSouthWestCoordinate());

    return neighbors;
  }

  Coordinates getWestNorthCoordinate() {
    return neighbor(WEST, NORTH);
  }

  Coordinates getNorthCoordinate() {
    return neighbor(SAME, NORTH);
  }

  Coordinates getNorthEastCoordinate() {
    return neighbor(EAST, NORTH);
  }

  Coordinates getWestCoordinate() {
    return neighbor(WEST, SAME);
  }

  Coordinates getEastCoordinate() {
    return neighbor(EAST, SAME);
  }

  Coordinates getSouthEastCoordinate() {
    return neighbor(EAST, SOUTH);
  }

  Coordinates getSouthCoordinate() {
    return neighbor(SAME, SOUTH);
  }

  Coordinates getSouthWestCoordinate() {
    return neighbor(WEST, SOUTH);
  }

  private Coordinates neighbor(int diff_X, int diff_Y) {
    return new Coordinates(x + diff_X, y + diff_Y);
  }


  public Coordinates(int x, int y) {
    this.x = x;
    this.y = y;
  }


}
