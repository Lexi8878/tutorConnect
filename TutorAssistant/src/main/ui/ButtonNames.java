package ui;

public enum ButtonNames {
    ADD("Add"),
    GO_TO_ADD("Sign-up"),
    GO_TO_FIND_TUTOR("Find tutor assistants"),
    GENERATE_TUTOR("Find"),
    SAVE("Save info"),
    LOAD("Load info");

    private final String name;

    ButtonNames(String name) {
        this.name = name;
    }

    public String getValue() {
        return name;
    }
}
