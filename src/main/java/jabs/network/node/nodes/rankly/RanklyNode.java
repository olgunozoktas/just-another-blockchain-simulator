package jabs.network.node.nodes.rankly;

import jabs.consensus.algorithm.PBFT;
import jabs.consensus.blockchain.LocalBlockTree;
import jabs.ledgerdata.Vote;
import jabs.ledgerdata.pbft.PBFTBlock;
import jabs.ledgerdata.pbft.PBFTTx;
import jabs.network.networks.Network;
import jabs.network.node.nodes.Node;
import jabs.network.node.nodes.PeerBlockchainNode;
import jabs.network.p2p.PBFTP2P;
import jabs.simulator.Simulator;

public class RanklyNode extends PeerBlockchainNode<PBFTBlock, PBFTTx> {
    public static final PBFTBlock PBFT_GENESIS_BLOCK = new PBFTBlock(0, 0, 0, null, null);

    public RanklyNode(Simulator simulator, Network network, int nodeID, long downloadBandwidth, long uploadBandwidth, int numAllParticipants) {
        super(simulator, network, nodeID, downloadBandwidth, uploadBandwidth, new PBFTP2P(), new PBFT<>(new LocalBlockTree<>(PBFT_GENESIS_BLOCK), numAllParticipants));
        this.consensusAlgorithm.setNode(this);
    }

    @Override
    protected void processNewTx(PBFTTx tx, Node from) {
        // nothing for now
    }

    @Override
    protected void processNewBlock(PBFTBlock block) {
        // nothing for now
    }

    @Override
    protected void processNewVote(Vote vote) {
        ((PBFT<PBFTBlock, PBFTTx>) this.consensusAlgorithm).newIncomingVote(vote);
    }

    @Override
    protected void processNewQuery(jabs.ledgerdata.Query query) {

    }

    @Override
    public void generateNewTransaction() {
        // nothing for now
    }
}
