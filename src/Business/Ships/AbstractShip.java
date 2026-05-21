package Business.Ships;

import utils.math.Vector2;

public abstract class AbstractShip implements Ship {
    protected final int size;
    protected Vector2 direction;
    protected ShipPart[] parts;
    public AbstractShip(int size, Vector2 direction) {
        this.size = size;
        this.direction = direction;
        this.parts = new ShipPart[size];
        for (int i = 0; i < size; i++) {
            parts[i] = new ShipPart(this, i);
        }
    }

    @Override
    public ShipPart getShipPart(int index) {
        return parts[index];
    }
}
