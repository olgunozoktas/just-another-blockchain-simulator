package jabs.ledgerdata.template;

import jabs.ledgerdata.Tx;

/**
 * A transaction for the Template blockchain
 */
public class TransactionTemplate extends Tx<TransactionTemplate> {
    /**
     * @param size     The size of the transaction in bytes
     * @param hashSize The size of the hash of the transaction in bytes
     */
    protected TransactionTemplate(int size, int hashSize) {
        super(size, hashSize);
    }
}
