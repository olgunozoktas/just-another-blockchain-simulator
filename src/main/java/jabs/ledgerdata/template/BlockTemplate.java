package jabs.ledgerdata.template;

import jabs.ledgerdata.SingleParentBlock;
import jabs.network.node.nodes.Node;

/**
 * A block for the Template blockchain
 */
public class BlockTemplate extends SingleParentBlock<BlockTemplate> {
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
    public BlockTemplate(int size, int height, double creationTime, Node creator, BlockTemplate parent) {
        super(size, height, creationTime, creator, parent, BLOCK_HASH_SIZE);
    }
}
