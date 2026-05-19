package net.ramixin.dynamo.fabric.events.contexts;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.ramixin.stator.events.contexts.PlayerJoinedServerContext;

public record PlayerJoinedServerContextImpl(ServerPlayer player) implements PlayerJoinedServerContext {

    public PlayerJoinedServerContextImpl(ServerGamePacketListenerImpl handler) {
        this(handler.getPlayer());
    }

}
