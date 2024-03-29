package net.daocreationgod.eliastellariamod.item;

import net.daocreationgod.eliastellariamod.EliaModIndex;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EliaModIndex.MOD_ID);


    //Here we add the items
    //First under this is an example explaining it
    //public static final RegistryObject<Item> NAME_WITH_UNDERSCORE_FOR_SPACES = ITEMS.register("name_with_underscore_for_spaces", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_ELIUM = ITEMS.register("raw_elium", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ELIUM_INGOT = ITEMS.register("elium_ingot", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
