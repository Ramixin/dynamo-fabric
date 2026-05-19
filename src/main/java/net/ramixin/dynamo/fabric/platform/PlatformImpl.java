package net.ramixin.dynamo.fabric.platform;

import net.fabricmc.loader.api.FabricLoader;
import net.ramixin.stator.platform.PlatformService;

import java.nio.file.Path;

public final class PlatformImpl implements PlatformService {

    @Override
    public String getPlatformName() {
        return "fabric";
    }

    @Override
    public Path getGameDirectory() {
        return FabricLoader.getInstance().getGameDir();
    }

    @Override
    public boolean isDevEnv() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }
}
