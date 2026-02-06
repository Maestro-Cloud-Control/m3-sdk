package io.maestro3.sdk.v3.model.billing;

public enum BillingFileType {
    JSON(".json"), CSV(".csv"), XLSX(".xlsx");

    private final String fileExtension;

    BillingFileType(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public String getFileExtension() {
        return fileExtension;
    }
}
