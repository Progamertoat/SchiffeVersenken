package Business.Ships;


import utils.math.Vector2;

public interface Ship {
    int getSize();
    Vector2 getDirection();
    ShipPart getShipPart(int index);
    Vector2 getPosition();


}
