package jabs.scenario;

import jabs.consensus.config.NakamotoConsensusConfig;
import jabs.ledgerdata.bitcoin.BitcoinBlockWithTx;
import jabs.network.networks.bitcoin.BitcoinGlobalProofOfWorkNetwork;
import jabs.network.stats.eightysixcountries.bitcoin.BitcoinProofOfWorkGlobalNetworkStats86Countries;

import static jabs.network.stats.eightysixcountries.bitcoin.BitcoinProofOfWorkGlobalNetworkStats86Countries.BITCOIN_DIFFICULTY_2022;

public class BitcoinGlobalNetworkScenarioWithTransaction extends AbstractScenario {
    public final double stopTime;
    public final double averageBlockInterval;
    public final int confirmationDepth;

    /**
     * creates a Bitcoin network scenario with parameters close to real-world but excluding transaction simulation for
     * better simulation speed
     *
     * @param name                 determines the name of simulation scenario
     * @param seed                 this value gives the simulation seed value for randomness engine
     * @param stopTime             this determines how many seconds of simulation world time should it last.
     * @param averageBlockInterval This determines the interval between two block generations in seconds.
     * @param confirmationDepth    The depth at which a block is considered confirmed (eg. 6)
     */
    public BitcoinGlobalNetworkScenarioWithTransaction(String name, long seed, long stopTime, double averageBlockInterval, int confirmationDepth) {
        super(name, seed);
        this.stopTime = stopTime;
        this.averageBlockInterval = averageBlockInterval;
        this.confirmationDepth = confirmationDepth;
    }

    /**
     * Creates the network and populates it with miners and nodes almost equal to the real world.
     */
    @Override
    protected void createNetwork() {
        BitcoinGlobalProofOfWorkNetwork<?> bitcoinNetwork = new BitcoinGlobalProofOfWorkNetwork<>(randomnessEngine, new BitcoinProofOfWorkGlobalNetworkStats86Countries(randomnessEngine));
        System.err.print("Bitcoin network formed\n");
        this.network = bitcoinNetwork;
        bitcoinNetwork.populateNetwork(
                simulator,
                new NakamotoConsensusConfig(
                        BitcoinBlockWithTx.generateGenesisBlock(BITCOIN_DIFFICULTY_2022),
                        this.averageBlockInterval,
                        this.confirmationDepth
                )
        );
    }

    /**
     * Starts mining in the network by creating mining processes for each node.
     */
    @Override
    protected void insertInitialEvents() {
        ((BitcoinGlobalProofOfWorkNetwork<?>) network).startAllMiningProcesses();
    }

    /**
     * Stops simulation after `stopTime`
     *
     * @return true if stopTime is passed
     */
    @Override
    protected boolean simulationStopCondition() {
        return simulator.getSimulationTime() > stopTime;
    }
}
