package me.wallhacks.spark.systems.module.modules.mics;

import me.wallhacks.spark.Spark;
import me.wallhacks.spark.event.client.InputEvent;
import me.wallhacks.spark.systems.module.Module;
import me.wallhacks.spark.util.MC;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.UUID;

@Module.Registration(name = "MiddleClick", enabled = true, description = "Middle click players to add them to friends list")
public class MiddleClick extends Module{

    @SubscribeEvent
    public void onInputEvent(InputEvent event) {
        if (!nullCheck() && event.getKey() == -4) {
            RayTraceResult r = MC.mc.objectMouseOver;
            if (r.entityHit instanceof EntityPlayer) {
                String player = ((EntityPlayer) r.entityHit).getGameProfile().getName();
                if (Spark.socialManager.isFriend(player)) {
                    Spark.socialManager.removeFriend(player);
                } else Spark.socialManager.addFriend(player);
            }
        }
    }
}
