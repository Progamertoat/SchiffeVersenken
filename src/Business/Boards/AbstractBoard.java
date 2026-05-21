package Business.Boards;

import Business.Ships.Ship;
import Business.Ships.ShipPart;
import utils.math.Vector2;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractBoard implements Board {
    protected final ShipPart[][] field;
    protected final List<Ship> ships;
    protected AbstractBoard(int size) {
        field = new ShipPart[size][size];
        ships = new ArrayList<>();
    }

    @Override
    public ShipPart[][] getField() {
        return field;
    }
    public int getSize() {
        return field.length;
    }

    private ShipPart getShipPart(Vector2 position) {
        return field[position.x()][position.y()];
    }

    public boolean addShip(Ship ship, Vector2 position) {

        if (position.x() < 0 || position.x() >= getSize()) {
            return false;
        }
        if (position.y() < 0 || position.y() >= getSize()) {
            return false;
        }
        Vector2 endPosition = getPositionOfShipPart(ship, position, ship.getSize() -1);
        if (endPosition.x() < 0 || endPosition.x() >= getSize()) {
            return false;
        }
        if (endPosition.y() < 0 || endPosition.y() >= getSize()) {
            return false;
        }
        int count = ship.getSize();
        for (int i = 0; i < count; i++) {
            Vector2 shipPartPosition = getPositionOfShipPart(ship, position, i);
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    if (dx == 0 && dy == 0) {
                        continue;
                    }
                    Vector2 checkPosition = Vector2.add(shipPartPosition, new Vector2(dx, dy));
                    if (checkPosition.x() < 0 || checkPosition.x() >= getSize() || checkPosition.y() < 0 || checkPosition.y() >= getSize()) {
                        continue;
                    }
                    ShipPart potentialShipPart = field[checkPosition.x()][checkPosition.y()];
                    if (potentialShipPart != null && !potentialShipPart.isOfSameShip(ship.getShipPart(i)) ) {
                        return false;
                    }
                }
            }
            field[position.x()][position.y()] = ship.getShipPart(i);
        }
        return true;
    }
    @Override
    public boolean tryToShootAt(Vector2 position) throws IndexOutOfBoundsException {
        if (position.x() < 0 || position.x() >= getSize()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (position.y() < 0 || position.y() >= getSize()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        ShipPart shipPart = getShipPart(position);
        if (shipPart == null) {
            return false;
        }
        if (shipPart.isHit()) {
            return false;
        }
        shipPart.hit();
        return true;
    }
    private static Vector2 getPositionOfShipPart(Ship ship, Vector2 position, int scale) {
        return Vector2.add(position, Vector2.scale(ship.getDirection(), scale));
    }

}
