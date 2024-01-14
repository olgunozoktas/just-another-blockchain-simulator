In order to create a new scenario follow these steps:

# How to create a new scenario

To Create a new scenario file under `src/main/java/scenarios` folder. 

- You can use `src/main/java/scenarios/ScenarioTemplate.java` as a template. 
- Put your scenario file under `src/main/java/scenario` folder.
- In every scenario there must be a createNetwork method which creates the network and returns the network object.
- In every scenario there must be a insertInitialEvents method which inserts the initial events to the network.

## How to create a Network for your scenario

Network is necessary for every blockchain simulation. In order to create a network you need to create a new class that extends `Network` class.
- Network class has a constructor which takes a `RandomnessEngine` and `NetworkStats` as an argument. 
  - You can use `NetworkConfiguration` class to configure your network.
- 

- You can use `src/main/java/networks/NetworkTemplate.java` as a template.