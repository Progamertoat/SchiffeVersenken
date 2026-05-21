package Business.Boards;

import Business.Ships.Ship;
import Business.Ships.ShipPart;
import utils.math.Vector2;

public interface Board {
    ShipPart[][] getField();
    int getSize();
    boolean addShip(Ship ship, Vector2 position);
    boolean tryToShootAt(Vector2 position);
}
