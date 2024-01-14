package jabs.scenario;

import jabs.consensus.config.PBFTConsensusConfig;
import jabs.network.networks.pbft.PBFTLocalLANNetwork;
import jabs.network.networks.rankly.RanklyLocalLANNetwork;

/**
 * File: RanklyNetworkScenario.java
 */
public class RanklyNetworkScenario extends AbstractScenario {

    /**
     * numNodes determines the number of nodes in the network
     */
    protected int numNodes;
    /**
     * stopTime determines the time that simulation should stop
     */
    public final double stopTime;
    /**
     * averageBlockInterval determines the interval between two block generations in seconds.
     */
    public final double averageBlockInterval;

    /**
     * creates a Bitcoin network by using rankly consensus algorithm scenario with parameters close to real-world but excluding transaction simulation for
     * better simulation speed
     *
     * @param name                 determines the name of simulation scenario
     * @param seed                 this value gives the simulation seed value for randomness engine
     * @param stopTime             this determines how many seconds of simulation world time should it last.
     * @param averageBlockInterval This determines the interval between two block generations in seconds.
     */
    public RanklyNetworkScenario(String name, long seed, int numNodes, long stopTime, double averageBlockInterval) {
        super(name, seed);
        this.numNodes = numNodes;
        this.stopTime = stopTime;
        this.averageBlockInterval = averageBlockInterval;
    }

    @Override
    protected void createNetwork() {
        network = new RanklyLocalLANNetwork(randomnessEngine);
        network.populateNetwork(this.simulator, this.numNodes, new PBFTConsensusConfig());
    }

    @Override
    protected void insertInitialEvents() {

    }

    @Override
    protected boolean simulationStopCondition() {
        return false;
    }
}
