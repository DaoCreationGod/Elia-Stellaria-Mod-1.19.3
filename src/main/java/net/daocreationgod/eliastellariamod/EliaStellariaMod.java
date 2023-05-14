package net.daocreationgod.eliastellariamod;

import com.mojang.logging.LogUtils;
import net.daocreationgod.eliastellariamod.block.ModBlocks;
import net.daocreationgod.eliastellariamod.item.ModCreativeModeTabs;
import net.daocreationgod.eliastellariamod.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(EliaStellariaMod.MOD_ID)
public class EliaStellariaMod {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "elia_stellaria_mod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "elia_stellaria_mod" namespace

    public EliaStellariaMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event){}

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == ModCreativeModeTabs.ELIA_STELLARIA_MOD_TAB) {
            event.accept(ModBlocks.BANANA_TREE_WOOD);
            event.accept(ModBlocks.MAGIC_BANANA_TREE_WOOD);
            event.accept(ModBlocks.HATEFUL_BANANA_TREE_WOOD);
            event.accept(ModBlocks.HATEFUL_MAGIC_BANANA_TREE_WOOD);
            event.accept(ModBlocks.FALLEN_STAR_BLOCK);
            event.accept(ModBlocks.HATEFUL_FALLEN_STAR_BLOCK);
            event.accept(ModBlocks.ELIUM_BLOCK);
            event.accept(ModBlocks.ELIUM_ORE_BLOCK);
            event.accept(ModBlocks.NETHER_ELIUM_ORE_BLOCK);
            event.accept(ModBlocks.DEEPSLATE_ELIUM_ORE_BLOCK);
            event.accept(ModItems.RAW_ELIUM);
            event.accept(ModItems.ELIUM_INGOT);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
