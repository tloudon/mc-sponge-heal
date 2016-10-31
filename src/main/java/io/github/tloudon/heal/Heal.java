package io.github.tloudon.heal;

import com.google.inject.Inject;
import org.slf4j.Logger;

import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.command.spec.CommandSpec;

import io.github.tloudon.heal.HealCommand;


@Plugin(id = "tloudon-heal", name = "Heal", version = "0.1")

public class Heal {
    @Inject
    private Logger logger;

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        getLogger().info("HEAL LOADED!");

        CommandSpec healCommandSpec = CommandSpec.builder()
            .description(Text.of("Heal Your Player"))
            .executor(new HealCommand())
            .build();
        Sponge.getCommandManager().register(this, healCommandSpec, "heal", "hp");

    }

    public Logger getLogger() {
        return logger;
    }
}
