package bacteria;

import java.util.HashSet;
import java.util.Set;

public class World {

  private Set<Coordinates> liveCellCoordinatesOnWorld = new HashSet<Coordinates>();

  public Set<Coordinates> getLiveCellCoordinates() {
    return liveCellCoordinatesOnWorld;
  }

  public void addLiveCellsAt(Coordinates newCell) {
    liveCellCoordinatesOnWorld.add(newCell);
  }

  //could be replased by Streams and Lambdas
  int countOfLiveBacteriasInside(Set<Coordinates> ambientCoordinates) {
    int count = 0;
    for (Coordinates neighbor : ambientCoordinates) {
      if (liveCellCoordinatesOnWorld.contains(neighbor)) {
        count++;
      }
    }
    return count;
  }

  public void startGeneration() {
    Set<Coordinates> nextGeneration = new HashSet<Coordinates>();
    for (Coordinates coordinate : liveCellCoordinatesOnWorld) {

      int liveNeighvorCount = countOfLiveBacteriasInside(coordinate.neighborCoordinates());

      if (liveNeighvorCount == 2 || liveNeighvorCount == 3) {
        nextGeneration.add(coordinate);
      }
      if (liveNeighvorCount < 2 || liveNeighvorCount > 4) {
      } //if less than 2 or more than 4 they "dead" and we cont need to add them
      applyRulesToNeighboringCoordinatesWithDeadBacterias(coordinate, nextGeneration);
    }
    liveCellCoordinatesOnWorld = nextGeneration;

  }

  private void applyRulesToNeighboringCoordinatesWithDeadBacterias(Coordinates coordinate,
      Set<Coordinates> nextGeneration) {
    for (Coordinates neighbor : neighborCoordinatesWithDeadBacteria(coordinate)) {
      int liveNeighborCount = countOfLiveBacteriasInside(neighbor.neighborCoordinates());
      if (liveNeighborCount == 3) {
        nextGeneration.add(neighbor);
      }
    }
  }

  private Set<Coordinates> neighborCoordinatesWithDeadBacteria(Coordinates coordinateForCheck) {
    Set<Coordinates> neighborCoordinatesWithDeadBacteria = new HashSet<Coordinates>();
    for (Coordinates neighborCoordinate : coordinateForCheck.neighborCoordinates()) {
      if (!liveCellCoordinatesOnWorld.contains(neighborCoordinate)) {
        neighborCoordinatesWithDeadBacteria.add(neighborCoordinate);
      }
    }
    return neighborCoordinatesWithDeadBacteria;
  }

}
