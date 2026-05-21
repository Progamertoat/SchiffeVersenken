package Business.Ships;

public class ShipPart {
    protected Ship ship;
    protected int number;
    protected boolean isHit;
    public ShipPart(Ship ship, int number) {
        this.ship = ship;
        this.number = number;
        this.isHit = false;
    }
    public void hit() {
        this.isHit = true;
    }

    public boolean isHit() {
        return isHit;
    }

    public boolean isOfSameShip(ShipPart otherShipPart) {
        return this.ship == otherShipPart.ship;
    }

}
