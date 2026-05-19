package net.ramixin.dynamo.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.ramixin.stator.StatorInitializer;

public class Dynamo implements ModInitializer {

    @Override
    public void onInitialize() {
        FabricLoader.getInstance().invokeEntrypoints("stator:main", StatorInitializer.class, StatorInitializer::initialize);
    }

}
