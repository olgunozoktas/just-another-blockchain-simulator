package jabs.network.node.nodes.rankly;

import jabs.consensus.algorithm.PBFT;
import jabs.consensus.algorithm.Snow;
import jabs.consensus.blockchain.LocalBlockTree;
import jabs.ledgerdata.Vote;
import jabs.ledgerdata.pbft.PBFTBlock;
import jabs.ledgerdata.pbft.PBFTTx;
import jabs.ledgerdata.rankly.RanklyBlock;
import jabs.ledgerdata.rankly.RanklyTransaction;
import jabs.network.networks.Network;
import jabs.network.node.nodes.Node;
import jabs.network.node.nodes.PeerBlockchainNode;
import jabs.network.p2p.PBFTP2P;
import jabs.network.p2p.SnowP2P;
import jabs.simulator.Simulator;

/**
 * A node for the Rankly blockchain
 */
public class RanklyNode extends PeerBlockchainNode<RanklyBlock, RanklyTransaction> {
    /**
     * The genesis block for the Rankly blockchain
     */
    public static final RanklyBlock RANKLY_GENESIS_BLOCK = new RanklyBlock(0, 0, 0, null, null);

    /**
     * @param simulator          The simulator that the node is running on
     * @param network            The network that the node is a part of
     * @param nodeID             The ID of the node
     * @param downloadBandwidth  The download bandwidth of the node in bytes per second
     * @param uploadBandwidth    The upload bandwidth of the node in bytes per second
     * @param numAllParticipants The number of all participants in the network
     */
    public RanklyNode(Simulator simulator, Network network, int nodeID, long downloadBandwidth, long uploadBandwidth, int numAllParticipants) {
        super(simulator, network, nodeID, downloadBandwidth, uploadBandwidth,
                new SnowP2P(),
                new Snow<>(new LocalBlockTree<>(RANKLY_GENESIS_BLOCK), numAllParticipants)
        );
        this.consensusAlgorithm.setNode(this);
    }

    @Override
    protected void processNewTx(RanklyTransaction tx, Node from) {
        // nothing for now
    }

    @Override
    protected void processNewBlock(RanklyBlock block) {
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
