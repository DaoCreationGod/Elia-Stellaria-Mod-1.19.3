package net.daocreationgod.eliastellariamod.item;

import net.daocreationgod.eliastellariamod.EliaStellariaMod;
import net.daocreationgod.eliastellariamod.block.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EliaStellariaMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {

    public static CreativeModeTab ELIA_STELLARIA_MOD_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event){
        ELIA_STELLARIA_MOD_TAB = event.registerCreativeModeTab(new ResourceLocation(EliaStellariaMod.MOD_ID, "elia_stellaria_mod_tab"), builder -> builder.icon(()-> new ItemStack(ModBlocks.FALLEN_STAR_BLOCK.get())).title(Component.translatable("creativemodetab.elia_stellaria_mod_tab")));
    }
}
