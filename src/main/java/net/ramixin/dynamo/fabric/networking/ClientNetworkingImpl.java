package net.ramixin.dynamo.fabric.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.ramixin.stator.networking.ClientNetworkingService;
import net.ramixin.stator.networking.ClientPayloadHandlerContext;

import java.util.function.Consumer;

public final class ClientNetworkingImpl implements ClientNetworkingService {
    @Override
    public <T extends CustomPacketPayload> void registerClientboundHandler(CustomPacketPayload.Type<T> type, Consumer<ClientPayloadHandlerContext<T>> handler) {
        ClientPlayNetworking.registerGlobalReceiver(type, (payload, ctx) -> handler.accept(new ClientPayloadHandlerContextImpl<>(payload, ctx)));
    }

    @Override
    public void sendServerbound(CustomPacketPayload payload) {
        ClientPlayNetworking.send(payload);
    }
}
