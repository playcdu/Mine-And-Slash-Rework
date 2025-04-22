package com.robertx22.mine_and_slash.vanilla_mc.packets.backpack;

import com.robertx22.library_of_exile.main.MyPacket;
import com.robertx22.library_of_exile.packets.ExilePacketContext;
import com.robertx22.mine_and_slash.capability.player.data.Backpacks;
import com.robertx22.mine_and_slash.mmorpg.SlashRef;
import com.robertx22.mine_and_slash.uncommon.datasaving.Load;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraftforge.client.event.sound.SoundEvent;

public class BackPackLootMenuPacket extends MyPacket<BackPackLootMenuPacket> {
    @Override
    public ResourceLocation getIdentifier() {
        return SlashRef.id("backpack_loot");
    }

    @Override
    public void loadFromData(FriendlyByteBuf friendlyByteBuf) {

    }

    @Override
    public void saveToData(FriendlyByteBuf friendlyByteBuf) {

    }

    @Override
    public void onReceived(ExilePacketContext exilePacketContext) {
        if (exilePacketContext.getPlayer() instanceof ServerPlayer player) {
            Backpacks backpacks = Load.backpacks(player).getBackpacks();
            if (player.hasContainerOpen() && player.containerMenu instanceof ChestMenu chestMenu) {
                for (Slot slot : chestMenu.slots) {
                    backpacks.tryAutoPickup(player, slot.getItem(), false);
                }
            }

        }
    }

    @Override
    public MyPacket<BackPackLootMenuPacket> newInstance() {
        return new BackPackLootMenuPacket();
    }
}
