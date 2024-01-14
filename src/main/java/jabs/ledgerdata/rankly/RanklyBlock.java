package jabs.ledgerdata.rankly;

import jabs.ledgerdata.SingleParentBlock;
import jabs.network.node.nodes.Node;

/**
 * A block for the Rankly blockchain
 */
public class RanklyBlock extends SingleParentBlock<RanklyBlock> {
    /**
     * The size of the hash of the block in bytes
     */
    public static final int BLOCK_HASH_SIZE = 32;

    /**
     * @param size         The size of the block in bytes
     * @param height       The height of the block in the blockchain
     * @param creationTime The time at which the block was created
     * @param creator      The node that created the block
     * @param parent       The parent block of this block
     */
    public RanklyBlock(int size, int height, double creationTime, Node creator, RanklyBlock parent) {
        super(size, height, creationTime, creator, parent, BLOCK_HASH_SIZE);
    }
}
