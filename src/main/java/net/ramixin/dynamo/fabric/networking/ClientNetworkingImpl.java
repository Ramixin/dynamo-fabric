package net.ramixin.dynamo.fabric.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.ramixin.stator.networking.ClientNetworkingService;

public final class ClientNetworkingImpl implements ClientNetworkingService {

    @Override
    public void sendServerbound(CustomPacketPayload payload) {
        ClientPlayNetworking.send(payload);
    }
}
