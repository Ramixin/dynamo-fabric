package net.ramixin.dynamo.fabric.events;

import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.ramixin.dynamo.fabric.events.contexts.PlayerJoinedServerContextImpl;
import net.ramixin.stator.events.Event;
import net.ramixin.stator.events.EventDispatcher;
import net.ramixin.stator.events.annotations.PlayerJoinedServerEvent;
import net.ramixin.stator.events.contexts.Context;
import net.ramixin.stator.events.contexts.PlayerJoinedServerContext;

import java.lang.annotation.Annotation;

public class PlayerJoinedServerEventImpl implements Event<PlayerJoinedServerContext, Void> {
    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return PlayerJoinedServerEvent.class;
    }

    @Override
    public Class<? extends Context> getContextClass() {
        return PlayerJoinedServerContext.class;
    }

    @Override
    public Class<Void> getReturnClass() {
        return void.class;
    }

    @Override
    public void registerNativeListener(EventDispatcher<PlayerJoinedServerContext, Void> dispatcher) {
        ServerPlayConnectionEvents.JOIN.register((handler, _, _) -> dispatcher.dispatch(new PlayerJoinedServerContextImpl(handler)));
    }
}
