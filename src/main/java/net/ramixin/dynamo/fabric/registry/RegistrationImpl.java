package net.ramixin.dynamo.fabric.registry;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.core.Registry;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.ramixin.dynamo.fabric.networking.PayloadHandlerContextImpl;
import net.ramixin.stator.networking.PayloadHandlerContext;
import net.ramixin.stator.registry.Registrant;
import net.ramixin.stator.registry.RegistrationService;

import java.util.function.Consumer;
import java.util.function.Supplier;

public final class RegistrationImpl implements RegistrationService {
    @Override
    public <T, V extends T> Registrant<V> entry(Registry<T> registry, Identifier id, Supplier<V> value) {
        V realValue = value.get();
        Registry.register(registry, id, realValue);
        return new RegistrantImpl<>(realValue);
    }

    @Override
    public <T extends CustomPacketPayload> void clientboundPayload(CustomPacketPayload.Type<T> type, StreamCodec<RegistryFriendlyByteBuf, T> codec) {
        PayloadTypeRegistry.clientboundPlay().register(type, codec);
    }

    @Override
    public <T extends CustomPacketPayload> void serverboundPayload(CustomPacketPayload.Type<T> type, StreamCodec<RegistryFriendlyByteBuf, T> streamCodec, Consumer<PayloadHandlerContext<T>> handler) {
        PayloadTypeRegistry.serverboundPlay().register(type, streamCodec);
        ServerPlayNetworking.registerGlobalReceiver(type, (payload, ctx) -> handler.accept(new PayloadHandlerContextImpl<>(payload, ctx)));
    }
}
