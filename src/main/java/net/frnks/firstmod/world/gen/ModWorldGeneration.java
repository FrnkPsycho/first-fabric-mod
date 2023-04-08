package net.frnks.firstmod.world.gen;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        ModOreGeneration.generateOres();
        // reminds that world gen has orders, check GenerationStep class
        ModTreeGeneration.generateTrees();
    }
}
