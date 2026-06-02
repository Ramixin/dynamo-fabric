package net.ramixin.dynamo.fabric.networking;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.ramixin.stator.networking.NetworkingService;

public final class NetworkingImpl implements NetworkingService {

    @Override
    public void sendClientbound(ServerPlayer player, CustomPacketPayload payload) {
        ServerPlayNetworking.send(player, payload);
    }
}
