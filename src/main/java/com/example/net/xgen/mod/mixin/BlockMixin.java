package net.xgen.mod.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public class BlockMixin {
    @Inject(method = "shouldDrawSide", at = @At("HEAD"), cancellable = true)
    private static void onShouldDrawSide(BlockState state, BlockView world, BlockPos pos, Direction side, BlockPos neighborPos, CallbackInfoReturnable<Boolean> info) {
        // Рентген-логика: если блок не руда, делаем его невидимым
        String name = state.getBlock().getTranslationKey();
        if (!name.contains("ore") && !name.contains("debris")) {
            info.setReturnValue(false);
        }
    }
}
