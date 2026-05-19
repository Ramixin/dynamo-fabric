package net.ramixin.dynamo.fabric.networking;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.world.entity.player.Player;
import net.ramixin.stator.networking.PayloadHandlerContext;

public record PayloadHandlerContextImpl<T>(T payload, Player player) implements PayloadHandlerContext<T> {

    public PayloadHandlerContextImpl(T payload, ServerPlayNetworking.Context ctx) {
        this(payload, ctx.player());
    }

}
