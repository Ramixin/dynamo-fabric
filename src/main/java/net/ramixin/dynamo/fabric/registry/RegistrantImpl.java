package net.ramixin.dynamo.fabric.registry;

import net.ramixin.stator.registry.Registrant;

public record RegistrantImpl<T>(T value) implements Registrant<T> {

    @Override
    public T get() {
        return value;
    }
}
