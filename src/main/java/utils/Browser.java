package utils;

public enum Browser {
    CHROME("chrome"),
    FIREFOX("firefox"),
    EDGE("edge"),
    OPERA("opera");

    private final String name;

    Browser(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
