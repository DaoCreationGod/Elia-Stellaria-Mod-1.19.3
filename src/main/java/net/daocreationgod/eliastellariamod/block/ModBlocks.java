package net.daocreationgod.eliastellariamod.block;

import net.daocreationgod.eliastellariamod.EliaModIndex;
import net.daocreationgod.eliastellariamod.block.custom.ModFlammableRotatedPillarBlock;
import net.daocreationgod.eliastellariamod.block.custom.ModHatefulFlammableRotatedPillarBlock;
import net.daocreationgod.eliastellariamod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EliaModIndex.MOD_ID);

    //Wood and related blocks
    public static final RegistryObject<Block> BANANA_TREE_WOOD = registerBlock("banana_tree_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(2f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MAGIC_BANANA_TREE_WOOD = registerBlock("magic_banana_tree_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_LOG).strength(3f).requiresCorrectToolForDrops()));

    //Hateful wood and related blocks
    public static final RegistryObject<Block> HATEFUL_BANANA_TREE_WOOD = registerBlock("hateful_banana_tree_wood", () -> new ModHatefulFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_LOG).strength(1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> HATEFUL_MAGIC_BANANA_TREE_WOOD = registerBlock("hateful_magic_banana_tree_wood", () -> new ModHatefulFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_LOG).strength(1.5f).requiresCorrectToolForDrops()));

    //Stone and related blocks
    public static final RegistryObject<Block> FALLEN_STAR_BLOCK = registerBlock("fallen_star_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(38f).requiresCorrectToolForDrops()));

    //Ores
    public static final RegistryObject<Block> ELIUM_ORE_BLOCK = registerBlock("elium_ore_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(38f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> NETHER_ELIUM_ORE_BLOCK = registerBlock("nether_elium_ore_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(38f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEPSLATE_ELIUM_ORE_BLOCK = registerBlock("deepslate_elium_ore_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(38f).requiresCorrectToolForDrops()));

    //Hateful stone and related blocks
    public static final RegistryObject<Block> HATEFUL_FALLEN_STAR_BLOCK = registerBlock("hateful_fallen_star_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(19f).requiresCorrectToolForDrops()));

    //Metal and related blocks
    public static final RegistryObject<Block> ELIUM_BLOCK = registerBlock("elium_block", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(50f).requiresCorrectToolForDrops()));

    //Foliage and related blocks

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
