package jabs.ledgerdata.rankly;

import jabs.ledgerdata.SingleParentBlock;
import jabs.network.node.nodes.Node;

public class RanklyBlock extends SingleParentBlock<RanklyBlock> {
    public static final int BLOCK_HASH_SIZE = 32;

    public RanklyBlock(int size, int height, double creationTime, Node creator, RanklyBlock parent) {
        super(size, height, creationTime, creator, parent, BLOCK_HASH_SIZE);
    }
}
