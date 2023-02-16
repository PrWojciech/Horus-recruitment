package compositeBlock;

import block.IBlock;

import java.util.List;

public interface ICompositeBlock extends IBlock {
    List<IBlock> getBlocks();
}
