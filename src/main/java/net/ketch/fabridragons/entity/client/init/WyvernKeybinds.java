package net.ketch.fabridragons.entity.client.init;


import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.input.Input;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public class WyvernKeybinds {
//    public static KeyBinding primaryAttackKey;
//    public static KeyBinding secondaryAttackKey;
    public static KeyBinding downKey;

//    public static KeyBinding forwardKey; //don't konw if I need forward

    public static void init(){
        downKey = new KeyBinding("key.fabridragons.downKey", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, "key.category.fabridragons");
        //forwardKey = new KeyBinding("key.fabridragons.forwardKey", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, "key.category.fabridragons");
//        primaryAttackKey = new KeyBinding("key.fabridragons.primaryAttackKey", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_G, "key.category.fabridragons");
//        secondaryAttackKey = new KeyBinding("key.fabridragons.secondaryAttackKey", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_V, "key.category.fabridragons");

        KeyBindingHelper.registerKeyBinding(downKey);
        //KeyBindingHelper.registerKeyBinding(forwardKey);
        //KeyBindingHelper.registerKeyBinding(primaryAttackKey);
//        KeyBindingHelper.registerKeyBinding(secondaryAttackKey);

    }
}
