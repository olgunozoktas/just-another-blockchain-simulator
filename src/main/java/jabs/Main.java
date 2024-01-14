package jabs;

import jabs.ledgerdata.bitcoin.BitcoinBlockWithoutTx;
import jabs.log.*;
import jabs.scenario.*;

import java.io.IOException;
import java.nio.file.Paths;

/**
 *
 */
public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {
        AbstractScenario scenario;
        String BITCOIN = "bitcoin";
        String ETHEREUM = "ethereum";
        String PBFT = "pbft";
        String SNOWLAN = "snowlan";
        String RANKLY = "rankly";

        String consensus = RANKLY;

        if (consensus.equals(BITCOIN)) {
            int seed = 1;
            int stopTime = 86400;
            int averageBlockInterval = 600;
            int confirmationDepth = 6;

            /**
             * StopTime: number of minutes for simulation time
             * Elapsed Real Time and Simulation Time is not same
             * Ex: Simulation in progress... Elapsed Real Time: 0:00:46, Elapsed Simulation Time: 23:42:15
             */

            // Simulate one day in the life of Bitcoin network
            // Nakamoto protocol with block every 600 seconds
            // Around 8000 nodes with 30 miners
            scenario = new BitcoinGlobalNetworkScenario("One day in the life of Bitcoin", seed, stopTime, averageBlockInterval, confirmationDepth);
            scenario.AddNewLogger(new BlockConfirmationLogger(Paths.get("output/bitcoin-confirmations-log.csv")));
            scenario.AddNewLogger(new BlockPropagationDelayLogger(
                    Paths.get("output/bitcoin-50-propagation-delay-log.csv"), 0.5));
            scenario.AddNewLogger(new BlockPropagationDelayLogger(
                    Paths.get("output/bitcoin-90-propagation-delay-log.csv"), 0.9));
            scenario.AddNewLogger(new BlockchainReorgLogger<BitcoinBlockWithoutTx>(
                    Paths.get("output/bitcoin-reorgs-log.csv")));
            scenario.run();
        } else if (consensus.equals(ETHEREUM)) {
            // Simulate 1 hour in the life of Ethereum network
            // Ghost protocol with blocks every 14 seconds on average
            // Around 6000 nodes with 37 miners
            scenario = new NormalEthereumNetworkScenario("One hour in the life of Ethereum", 1,
                    3600, 13.3);
            scenario.AddNewLogger(new BlockPropagationDelayLogger(
                    Paths.get("output/ethereum-50-propagation-delay-log.csv"), 0.5));
            scenario.AddNewLogger(new BlockPropagationDelayLogger(
                    Paths.get("output/ethereum-90-propagation-delay-log.csv"), 0.9));
            scenario.AddNewLogger(new FinalUncleBlocksLogger(
                    Paths.get("output/ethereum-uncle-rate.csv")));
            scenario.run();
        } else if (consensus.equals(PBFT)) {
            // Simulate PBFT Lan network of 40 nodes for 1 hour
            scenario = new PBFTLANScenario("One hour of a PBFT lan Network", 1,
                    40, 3600);
            scenario.AddNewLogger(new PBFTCSVLogger(Paths.get("output/pbft-simulation-log.csv")));
            scenario.run();
        } else if (consensus.equals(RANKLY)) {
            // Simulate PBFT Lan network of 40 nodes for 1 hour
            scenario = new RanklyNetworkScenario("One hour of a PBFT lan Network", 1,
                    40, 3600);
//            scenario.AddNewLogger(new PBFTCSVLogger(Paths.get("output/pbft-simulation-log.csv")));
            scenario.run();
        } else {
            // Simulate Snow LAN network of 40 nodes for 1 hour
            scenario = new SnowLANScenario("One hour of a Snow lan Network", 1, 40, 3600);
            scenario.AddNewLogger(new SnowCSVLogger(Paths.get("output/snow-simulation-log.csv")));
            scenario.run();
        }
    }
}