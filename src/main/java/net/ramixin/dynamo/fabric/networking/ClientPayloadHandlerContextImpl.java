package net.ramixin.dynamo.fabric.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.world.entity.player.Player;
import net.ramixin.stator.networking.ClientPayloadHandlerContext;

public record ClientPayloadHandlerContextImpl<T>(T payload, Player player) implements ClientPayloadHandlerContext<T> {

    public ClientPayloadHandlerContextImpl(T payload, ClientPlayNetworking.Context ctx) {
        this(payload, ctx.player());
    }

}
