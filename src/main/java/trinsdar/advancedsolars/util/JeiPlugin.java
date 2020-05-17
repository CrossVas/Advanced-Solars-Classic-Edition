package trinsdar.advancedsolars.util;

import javax.annotation.Nonnull;

import ic2.core.platform.registry.Ic2Items;
import mezz.jei.api.IJeiRuntime;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.ingredients.IIngredientBlacklist;

@JEIPlugin
public class JeiPlugin implements IModPlugin {
	
	@Override
	public void onRuntimeAvailable(@Nonnull IJeiRuntime jeiRuntime) {}
	
	@Override
	public void register(@Nonnull IModRegistry registry) {
		IIngredientBlacklist blacklist = registry.getJeiHelpers().getIngredientBlacklist();
		if (AdvancedSolarsConfig.enabledItems.disableIC2CompactedSolarPanels) {
			blacklist.addIngredientToBlacklist(Ic2Items.lvSolarPanel);
			blacklist.addIngredientToBlacklist(Ic2Items.mvSolarPanel);
			blacklist.addIngredientToBlacklist(Ic2Items.hvSolarPanel);
		}
	}

}
