public class Location {
    private double latitude;
    private double longitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    // public void setLatitude(double latitude) {
    //     this.latitude = latitude;
    // }

    // public void setLongitude(double longitude) {
    //     this.longitude = longitude;
    // }

    @Override
    public String toString() {
        return "(" + latitude + ", " + longitude + ")";
    }
}
interface Locatable {
    Location getLocation();
}