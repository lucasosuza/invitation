package com.lucassouza.distance;

public class DistanceCalculator {

    public final static double EARTH_RADIUS = 6371e3;

    private final DitanceUnitsConverter ditanceUnitsConverter;

    public DistanceCalculator() {
        this.ditanceUnitsConverter = new DitanceUnitsConverter();
    }

    public static boolean lessThan100Km(double distance) {
        return distance < 100;
    }

    public double toDublin(double latitude, double longitude) {

        // φ, λ in radians
        double φ1 = ditanceUnitsConverter.toRadians(latitude);
        double φ2 = ditanceUnitsConverter.toRadians(DublinCoordinates.latitude);

        double Δλ = ditanceUnitsConverter.toRadians(DublinCoordinates.longitude - longitude);

        double Δσ = Math.acos(Math.sin(φ1) * Math.sin(φ2) + Math.cos(φ1) * Math.cos(φ2) * Math.cos(Δλ));

        if (Double.isNaN(Δσ)) return 0;

        // in metres
        double distance = EARTH_RADIUS * Δσ;

        return toKilometer(distance);
    }

    private double toKilometer(double distance) {
        return distance / 1000;
    }
}
