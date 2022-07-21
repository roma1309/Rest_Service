package rest_service.model.enums;

public enum ShipStatusType {
    PORT, SEA;

    public static ShipStatusType getStatusType(String statusInString) {
        for (ShipStatusType status : ShipStatusType.values()) {
            if (status.name().equals(statusInString)) {
                return status;
            }
        }
        return null;
    }
}
