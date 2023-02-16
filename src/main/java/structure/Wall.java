package structure;

import block.IBlock;
import compositeBlock.ICompositeBlock;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Wall implements IStructure {

    private final List<IBlock> blocks;

    public Wall(List<IBlock> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<IBlock> findBlockByColor(String color) {
        for (IBlock block : blocks) {
            if (block instanceof ICompositeBlock CB) {
                return findBlockByColor(color, CB);
            }
            if (Objects.equals(color, block.getColor())) {
                return Optional.of(block);
            }
        }
        return Optional.empty();
    }

    private Optional<IBlock> findBlockByColor(String color, ICompositeBlock compositeBlock) {
        for (IBlock block : compositeBlock.getBlocks()) {
            if (block instanceof ICompositeBlock CB) {
                return findBlockByColor(color, CB);
            }
            if (Objects.equals(color, block.getColor())) {
                return Optional.of(block);
            }
        }
        return Optional.empty();

    }

    @Override
    public List<IBlock> findBlocksByMaterial(String material) {
        List<IBlock> foundBlocks = new ArrayList<>();
        for (IBlock block : blocks) {
            if (Objects.equals(material, block.getMaterial())) {
                foundBlocks.add(block);
            }
            if (block instanceof ICompositeBlock CB) {
                findNestedBlockByMaterial(material, CB, foundBlocks);
            }
        }
        return foundBlocks;
    }

    public void findNestedBlockByMaterial(String material, ICompositeBlock compositeBlock, List<IBlock> foundBlocks) {
        for (IBlock block : compositeBlock.getBlocks()) {
            if (Objects.equals(material, block.getMaterial())) {
                foundBlocks.add(block);
            }
            if (block instanceof ICompositeBlock CB) {
                findNestedBlockByMaterial(material, CB, foundBlocks);
            }
        }
    }
    @Override
    public int count() {
        int count = 0;
        count = count(blocks, count);
        return count;
    }

    private int count(List<IBlock> blocks, int count) {
        for (IBlock block : blocks) {
            if (block != null) {
                count = count + 1;
            }
            if (block instanceof ICompositeBlock CB ) {
//                +1 wynika z faktu, ze copositeBlock jest rowniez blokiem
                count = count(CB.getBlocks(), count) +1;
            }
        }
        return count;
    }


}
