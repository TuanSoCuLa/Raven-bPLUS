//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "1.8.9"!

package keystrokesmod.main;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import keystrokesmod.*;
import keystrokesmod.keystroke.KeySrokeRenderer;
import keystrokesmod.keystroke.KeyStroke;
import keystrokesmod.keystroke.KeyStrokeConfigGui;
import keystrokesmod.keystroke.keystrokeCommand;
import keystrokesmod.module.Module;
import keystrokesmod.module.modules.ClickGui;
import keystrokesmod.module.modules.client.SelfDestruct;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;

@Mod(
   modid = "keystrokesmod",
   name = "KeystrokesMod",
   version = "KMV5",
   acceptedMinecraftVersions = "[1.8.9]"
)
public class Ravenb3 {
   public static final int ver = 3;
   public static boolean debugger = false;
   public static boolean outdated = false;
   public static boolean beta = false;
   private final String numberOfUseTracker = "https://pastebin.com/raw/EgBH4cxS";
   public static final String sourceLocation = "https://github.com/Kopamed/Raven-bPLUS";
   public static String[] updateText = {"Your version of Raven B+ (" + version.getCurrentVersion().replaceAll("-", ".") + ") is outdated!", "Enter the command update into client CommandLine to open the download page", "or just enable the update module to get a message in chat.", "Newest version: " + version.getLatestVersion().replaceAll("-", ".")};
   public static int a = 1;
   public static int b = 0;
   public static Minecraft mc;
   public static NotAName nan;
   private static KeyStroke keyStroke;
   private static KeySrokeRenderer keySrokeRenderer;
   private static boolean isKeyStrokeConfigGuiToggled;
   private static final ScheduledExecutorService ex = Executors.newScheduledThreadPool(2);

   public Ravenb3() {
      nan = new NotAName();
   }

   @EventHandler
   public void init(FMLInitializationEvent e) {
      mc =  Minecraft.getMinecraft();
      Runtime.getRuntime().addShutdownHook(new Thread(ex::shutdown));
      ClientCommandHandler.instance.registerCommand(new keystrokeCommand());
      FMLCommonHandler.instance().bus().register(this);
      FMLCommonHandler.instance().bus().register(new DebugInfoRenderer());
      FMLCommonHandler.instance().bus().register(new cl());
      FMLCommonHandler.instance().bus().register(new KeySrokeRenderer());
      FMLCommonHandler.instance().bus().register(new gp());
      nan.getm0dmanager().r3g1st3r();
      ConfigManager.applyKeyStrokeSettingsFromConfigFile();
      ConfigManager.applyCheatSettingsFromConfigFile();
      keySrokeRenderer = new KeySrokeRenderer();
      NotAName.clickGui = new ClickGui();
      ay.su();
      ex.execute(() -> URLUtils.getTextFromURL(this.numberOfUseTracker));
      if(version.outdated()) {
         Ravenb3.outdated = true;
      }
      if(version.isBeta()) {
         Ravenb3.beta = true;
      }
   }

   @EventHandler
   public void postInit(FMLPostInitializationEvent e) {
   }

   @SubscribeEvent
   public void onTick(ClientTickEvent e) {
      if (e.phase == Phase.END) {
         if (ay.isPlayerInGame() && !SelfDestruct.destructed) {
            for (Module module : nan.getm0dmanager().listofmods()) {
               if (mc.currentScreen == null) {
                  module.keybind();
               } else if (mc.currentScreen instanceof ClickGui) {
                  module.guiUpdate();
               }

               if (module.isEnabled()) {
                  module.update();
               }
            }
         }

         if (isKeyStrokeConfigGuiToggled) {
            isKeyStrokeConfigGuiToggled = false;
            mc.displayGuiScreen(new KeyStrokeConfigGui());
         }

      }
   }

   public void pingTracker() {

   }

   public static ScheduledExecutorService getExecutor() {
      return ex;
   }

   public static KeyStroke getKeyStroke() {
      return keyStroke;
   }

   public static KeySrokeRenderer getKeyStrokeRenderer() {
      return keySrokeRenderer;
   }

   public static void toggleKeyStrokeConfigGui() {
      isKeyStrokeConfigGuiToggled = true;
   }
}
