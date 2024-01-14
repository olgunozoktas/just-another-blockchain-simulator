package jabs.ledgerdata.rankly;

import jabs.ledgerdata.Tx;

public class PBFTTx extends Tx<PBFTTx> {
    protected PBFTTx(int size, int hashSize) {
        super(size, hashSize);
    }
}
