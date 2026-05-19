package net.ramixin.dynamo.fabric.events;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.ramixin.dynamo.fabric.events.contexts.CommandRegistrationContextImpl;
import net.ramixin.stator.events.Event;
import net.ramixin.stator.events.EventDispatcher;
import net.ramixin.stator.events.annotations.CommandRegistrationEvent;
import net.ramixin.stator.events.contexts.CommandRegistrationContext;
import net.ramixin.stator.events.contexts.Context;

import java.lang.annotation.Annotation;

public class CommandRegistrationEventImpl implements Event<CommandRegistrationContext, Void> {
    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return CommandRegistrationEvent.class;
    }

    @Override
    public Class<? extends Context> getContextClass() {
        return CommandRegistrationContext.class;
    }

    @Override
    public Class<Void> getReturnClass() {
        return void.class;
    }

    @Override
    public void registerNativeListener(EventDispatcher<CommandRegistrationContext, Void> dispatcher) {
        CommandRegistrationCallback.EVENT.register((dispatcherArg, context, selection) ->
                dispatcher.dispatch(new CommandRegistrationContextImpl(dispatcherArg, context, selection)));
    }
}
