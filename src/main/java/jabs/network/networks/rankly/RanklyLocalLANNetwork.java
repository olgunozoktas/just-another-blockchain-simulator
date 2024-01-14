package jabs.network.networks.rankly;

import jabs.consensus.config.ConsensusAlgorithmConfig;
import jabs.network.networks.Network;
import jabs.network.node.nodes.Node;
import jabs.network.node.nodes.rankly.RanklyNode;
import jabs.network.stats.lan.LAN100MNetworkStats;
import jabs.network.stats.lan.SingleNodeType;
import jabs.simulator.Simulator;
import jabs.simulator.randengine.RandomnessEngine;

/**
 * A network for the Rankly blockchain
 */
public class RanklyLocalLANNetwork extends Network<RanklyNode, SingleNodeType> {
    /**
     * @param randomnessEngine The randomness engine to use for the network
     */
    public RanklyLocalLANNetwork(RandomnessEngine randomnessEngine) {
        super(randomnessEngine, new LAN100MNetworkStats(randomnessEngine));
    }

    /**
     * @param simulator          The simulator that the network is running on
     * @param nodeID             The ID of the node
     * @param numAllParticipants The number of all participants in the network
     * @return A new Rankly node
     */
    public RanklyNode createNewRanklyNode(Simulator simulator, int nodeID, int numAllParticipants) {
        return new RanklyNode(simulator, this, nodeID,
                this.sampleDownloadBandwidth(SingleNodeType.LAN_NODE),
                this.sampleUploadBandwidth(SingleNodeType.LAN_NODE),
                numAllParticipants);
    }


    @Override
    public void populateNetwork(Simulator simulator, ConsensusAlgorithmConfig ranklyConsensusConfig) {
        populateNetwork(simulator, 40, ranklyConsensusConfig);
    }

    @Override
    public void populateNetwork(Simulator simulator, int numNodes, ConsensusAlgorithmConfig ranklyConsensusConfig) {
        for (int i = 0; i < numNodes; i++) {
            this.addNode(createNewRanklyNode(simulator, i, numNodes), SingleNodeType.LAN_NODE);
        }

        for (Node node : this.getAllNodes()) {
            node.getP2pConnections().connectToNetwork(this);
        }
    }

    /**
     * @param node A Rankly node to add to the network
     */
    @Override
    public void addNode(RanklyNode node) {
        this.addNode(node, SingleNodeType.LAN_NODE);
    }

}
