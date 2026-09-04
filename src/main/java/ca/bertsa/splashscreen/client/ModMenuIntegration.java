package ca.bertsa.splashscreen.client;

import ca.bertsa.splashscreen.CustomizeState;
import ca.bertsa.splashscreen.SplashScreenConfig;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;


public class ModMenuIntegration implements ModMenuApi {
    private static final String title = "Splashscreen Settings";


    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return ModMenuIntegration::getModConfigScreen;
    }

    public static Screen getModConfigScreen(Screen parent) {
        SplashScreenConfig.SplashConfig config = SplashScreenConfig.getConfig();
        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Component.literal(title));
        ConfigCategory general = builder.getOrCreateCategory(Component.literal("General"));
        ConfigEntryBuilder eb = builder.entryBuilder();

        general.addEntry(eb.startEnumSelector(Component.literal("Customize"), CustomizeState.class, config.state)
                .setSaveConsumer(customizeState -> config.state = customizeState)
                .build());
        general.addEntry(eb.startFloatField(Component.literal("Multiplier"), config.multiplier)
                .setSaveConsumer(val -> config.multiplier = val)
                .build());
        general.addEntry(eb.startIntField(Component.literal("Width"), config.width)
                .setSaveConsumer(val -> config.width = val)
                .build());
        general.addEntry(eb.startIntField(Component.literal("Height"), config.height)
                .setSaveConsumer(val -> config.height = val)
                .build());

        builder.setSavingRunnable(SplashScreenConfig::saveConfig);
        return builder.build();
    }
}

