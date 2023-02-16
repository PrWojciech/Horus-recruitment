package compositeBlock;

import block.IBlock;

import java.util.List;

public class CompositeBlock implements ICompositeBlock {
    List<IBlock> blocks;

    public CompositeBlock(List<IBlock> blocks) {
        this.blocks = blocks;
    }

    @Override
    public List<IBlock> getBlocks() {
        return this.blocks;
    }

    @Override
    public String getColor() {
        String color = null;
        for(IBlock block: blocks){
            if(color==null){
                color = block.getColor();

            }else if(!block.getColor().equals(color))    {
                color = "undefined";
            }

        }
        return color;
    }

    @Override
    public String getMaterial() {
        String material = null;
        for(IBlock block: blocks){
            if(material==null){
                material = block.getMaterial();
            }else if(!block.getMaterial().equals(material))    {
                material = "undefined";
            }
        }
        return material;
    }



}
