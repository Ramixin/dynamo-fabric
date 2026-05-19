package net.ramixin.dynamo.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.ramixin.stator.StatorClientInitializer;

public class DynamoClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        FabricLoader.getInstance().invokeEntrypoints("stator:client", StatorClientInitializer.class, StatorClientInitializer::initializeClient);
    }
}
