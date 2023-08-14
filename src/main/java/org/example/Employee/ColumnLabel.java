package org.example.Employee;

public enum ColumnLabel {
    ID("user_id"),
    NAME("user_name"),
    LAST_NAME("user_lastName"),
    EMAIL("user_email"),
    HOURLY_PAY("hourly_pay");

    public final String label;

    private ColumnLabel(String label) {
        this.label = label;
    }
}
