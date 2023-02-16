import block.Block;
import block.IBlock;
import structure.Wall;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        IBlock block = new Block("czerwony", "cegla");
        IBlock block1 = new Block("niebieski", "cegla");
        IBlock block2 = new Block("zielony", "cegla");
        List<IBlock> blocks = Arrays.asList(block, block1, block2);
        Wall wall = new Wall(blocks);
        System.out.println(blocks.size());
        System.out.println(wall.count());
        System.out.println(wall.findBlockByColor("czerwony"));
        System.out.println(wall.findBlocksByMaterial("cegla")
                               .get(1));

    }
}


