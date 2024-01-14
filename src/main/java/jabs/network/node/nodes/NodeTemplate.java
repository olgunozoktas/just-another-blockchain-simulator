package jabs.network.node.nodes;

import jabs.consensus.algorithm.Snow;
import jabs.consensus.blockchain.LocalBlockTree;
import jabs.ledgerdata.Vote;
import jabs.ledgerdata.rankly.RanklyBlock;
import jabs.ledgerdata.rankly.RanklyTransaction;
import jabs.ledgerdata.template.BlockTemplate;
import jabs.ledgerdata.template.TransactionTemplate;
import jabs.network.networks.Network;
import jabs.network.p2p.SnowP2P;
import jabs.simulator.Simulator;

/**
 * A node for the Template blockchain
 */
public class NodeTemplate extends PeerBlockchainNode<BlockTemplate, TransactionTemplate> {
    /**
     * The genesis block for the Template blockchain
     */
    public static final BlockTemplate GENESIS_BLOCK = new BlockTemplate(0, 0, 0, null, null);

    /**
     * @param simulator          The simulator that the node is running on
     * @param network            The network that the node is a part of
     * @param nodeID             The ID of the node
     * @param downloadBandwidth  The download bandwidth of the node in bytes per second
     * @param uploadBandwidth    The upload bandwidth of the node in bytes per second
     * @param numAllParticipants The number of all participants in the network
     */
    public NodeTemplate(Simulator simulator, Network network, int nodeID, long downloadBandwidth, long uploadBandwidth, int numAllParticipants) {
        super(simulator, network, nodeID, downloadBandwidth, uploadBandwidth, new SnowP2P(), new Snow<>(new LocalBlockTree<>(GENESIS_BLOCK), numAllParticipants));
        this.consensusAlgorithm.setNode(this);
    }

    @Override
    protected void processNewTx(TransactionTemplate tx, Node from) {
        // nothing for now
    }

    @Override
    protected void processNewBlock(BlockTemplate block) {
        // nothing for now
    }

    @Override
    protected void processNewVote(Vote vote) {

    }

    @Override
    protected void processNewQuery(jabs.ledgerdata.Query query) {

    }

    @Override
    public void generateNewTransaction() {
        // nothing for now
    }
}
