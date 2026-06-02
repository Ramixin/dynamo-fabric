package net.ramixin.dynamo.fabric.registry;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.ramixin.dynamo.fabric.networking.ClientPayloadHandlerContextImpl;
import net.ramixin.stator.networking.ClientPayloadHandlerContext;
import net.ramixin.stator.registry.ClientRegistrationService;
import net.ramixin.stator.registry.Registrant;
import org.apache.commons.lang3.function.TriFunction;

import java.util.function.Consumer;

public class ClientRegistrationImpl implements ClientRegistrationService {

    @Override
    public <T extends CustomPacketPayload> void clientboundHandler(CustomPacketPayload.Type<T> type, Consumer<ClientPayloadHandlerContext<T>> handler) {
        ClientPlayNetworking.registerGlobalReceiver(type, (payload, ctx) -> handler.accept(new ClientPayloadHandlerContextImpl<>(payload, ctx)));
    }

    @Override
    public <M extends AbstractContainerMenu, S extends Screen & MenuAccess<M>> void screen(Registrant<MenuType<M>> menuType, TriFunction<M, Inventory, Component, S> triFunction) {
        MenuScreens.register(menuType.get(), triFunction::apply);
    }
}
