package net.ramixin.dynamo.fabric.registry;

import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.ramixin.stator.registry.Registrant;
import net.ramixin.stator.registry.RegistrationService;

import java.util.function.Supplier;

public final class RegistrationImpl implements RegistrationService {
    @Override
    public <T, V extends T> Registrant<V> register(Registry<T> registry, Identifier id, Supplier<V> value) {
        V realValue = value.get();
        Registry.register(registry, id, realValue);
        return new RegistrantImpl<>(realValue);
    }
}
