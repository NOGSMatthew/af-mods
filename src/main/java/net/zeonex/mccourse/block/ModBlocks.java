package net.zeonex.mccourse.block;

import java.util.function.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zeonex.mccourse.MCCourseMod;
import net.zeonex.mccourse.item.Moditems;

public class ModBlocks {
        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
                        MCCourseMod.MOD_ID);

        public static final RegistryObject<Block> ALEXANDRITE_BLOCK = registerBlock("alexandrite_block",
                        () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                                        .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                                        .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
        public static final RegistryObject<Block> RAW_ALEXANDRITE_BLOCK = registerBlock("raw_alexandrite_block",
                        () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                                        .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                                        .requiresCorrectToolForDrops().strength(5.0F, -1F).sound(SoundType.METAL)));

        private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
                RegistryObject<T> toReturn = BLOCKS.register(name, block);
                registerBlockItem(name, toReturn);
                return toReturn;
        }

        private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
                return Moditems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        }

        public static void register(IEventBus eventBus) {
                BLOCKS.register(eventBus);
        }
}
