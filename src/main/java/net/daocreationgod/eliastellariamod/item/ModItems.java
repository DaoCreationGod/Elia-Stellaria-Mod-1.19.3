package net.daocreationgod.eliastellariamod.item;

import net.daocreationgod.eliastellariamod.EliaStellariaMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EliaStellariaMod.MOD_ID);


    //Here we add the items
    //First under this is an example explaining it
    public static final RegistryObject<Item> NAME_WITH_UNDERSCORE_FOR_SPACES = ITEMS.register("name_with_underscore_for_spaces", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
