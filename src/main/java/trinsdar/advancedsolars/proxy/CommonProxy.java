package trinsdar.advancedsolars.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import trinsdar.advancedsolars.util.AdvancedSolarsRecipes;
import trinsdar.advancedsolars.util.Registry;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent e) {
        Registry.init();
        Registry.registerTiles();
    }

    public void init(FMLInitializationEvent e) {
        AdvancedSolarsRecipes.init();
    }

    public void postInit(FMLPostInitializationEvent e) {
        // temporarily empty post init method
    }
}
