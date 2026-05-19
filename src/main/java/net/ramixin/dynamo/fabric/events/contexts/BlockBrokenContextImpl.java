package net.ramixin.dynamo.fabric.events.contexts;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.ramixin.stator.events.contexts.BlockBrokenContext;

public record BlockBrokenContextImpl(Level level, Player player, BlockPos blockPos, BlockState blockState, BlockEntity blockEntity) implements BlockBrokenContext {

}
