package jabs.ledgerdata.rankly;

import jabs.ledgerdata.Tx;

/**
 * A transaction for the Rankly blockchain
 */
public class RanklyTransaction extends Tx<RanklyTransaction> {
    /**
     * @param size     The size of the transaction in bytes
     * @param hashSize The size of the hash of the transaction in bytes
     */
    protected RanklyTransaction(int size, int hashSize) {
        super(size, hashSize);
    }
}
