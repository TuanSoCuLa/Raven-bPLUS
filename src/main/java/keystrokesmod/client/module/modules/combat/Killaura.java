package keystrokesmod.client.module.modules.combat;

import keystrokesmod.client.main.Raven;
import keystrokesmod.client.module.Module;
import keystrokesmod.client.module.setting.impl.SliderSetting;
import keystrokesmod.client.module.setting.impl.TickSetting;
import keystrokesmod.client.module.modules.world.AntiBot;
import keystrokesmod.client.utils.Utils;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.List;

public class Killaura extends Module {
    public static SliderSetting a;
    public static TickSetting b;
    private final SliderSetting assistMode;
    private static MovingObjectPosition mv;
    private final float[] manualPos = {75.6f, -315, -225, -135, -45, 0, 45, 135, 225, 315};
    private final float[] hypixelPos = {79.6f, -340, -290, -250, -200, -160, -110, -70, -20, 0, 20, 70, 110, 160, 200, 250, 290, 340};
    private final float[] testPos = {79.9f, -360, -270, -180, -90, 0, 90, 180, 270, 360};
    private final float[] testPos = {78f, -315, -225, -135, -45, 0, 45, 135, 225, 315};

    public Killaura() {
        this.registerSetting(a = new SliderSetting("APS", 8, 1, 20));
        this.registerSetting(assistMode = new SliderSetting("AutoBlock : Manual"));
    }

}