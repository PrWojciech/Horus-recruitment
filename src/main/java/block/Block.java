package block;

public class Block implements IBlock {
    private final String color;
    private final String material;

    public Block(String color, String material) {
        this.color = color;
        this.material = material;

    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String getMaterial() {
        return this.material;
    }
}


