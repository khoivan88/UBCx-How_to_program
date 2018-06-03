package model;

public abstract class Vegetable implements Growable {
    private String name;
    private VegType type;
    private String instructions;

    public Vegetable(String name, VegType type) {
        this.name = name;
        this.type = type;
        instructions = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(VegType type) {
        this.type = type;
    }

    @Override
    public String getInstructions() {
        return instructions;
    }

    protected void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public VegType getType() {
        return type;
    }
}
