package net.ramixin.dynamo.fabric.events;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.ramixin.dynamo.fabric.events.contexts.BlockBrokenContextImpl;
import net.ramixin.stator.events.Event;
import net.ramixin.stator.events.EventDispatcher;
import net.ramixin.stator.events.annotations.BlockBrokenEvent;
import net.ramixin.stator.events.contexts.BlockBrokenContext;

import java.lang.annotation.Annotation;

public final class BlockBrokenEventImpl implements Event<BlockBrokenContext, Void> {

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return BlockBrokenEvent.class;
    }

    @Override
    public Class<BlockBrokenContext> getContextClass() {
        return BlockBrokenContext.class;
    }

    @Override
    public Class<Void> getReturnClass() {
        return void.class;
    }

    @Override
    public void registerNativeListener(EventDispatcher<BlockBrokenContext, Void> dispatcher) {
        PlayerBlockBreakEvents.AFTER.register((level, player, pos, state, blockEntity) -> dispatcher.dispatch(new BlockBrokenContextImpl(level, player, pos, state, blockEntity)));
    }
}
