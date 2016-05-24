package com.akpwebdesign.sponge.MineSpeeder;

import org.slf4j.Logger;
import org.spongepowered.api.entity.EntityTypes;
import org.spongepowered.api.entity.vehicle.minecart.RideableMinecart;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.entity.MountEntityEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;

import com.google.inject.Inject;

@Plugin(id = "com.akpwebdesign.minespeeder", name = "MineSpeeder", version = "1.0")
public class MineSpeeder {
    @Inject
    private Logger logger;

    private double maxSwiftness;

    private static MineSpeeder instance;
    
    public MineSpeeder () {
        MineSpeeder.instance = this;
    }
    
    public Logger getLogger() {
        return logger;
    }
    
    public static MineSpeeder getPlugin() {
        return instance;
    }
    
    public double getMaxSwiftness() {
        return maxSwiftness;
    }

    public void setMaxSwiftness(double maxSwiftness) {
        this.maxSwiftness = maxSwiftness;
    }
    
    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        getLogger().debug("Server is starting!");
        //TODO: Get this from config file.
        this.setMaxSwiftness(0.4);
        
        this.registerCommands();
    }
    
    @Listener
    public void onEntityMount(MountEntityEvent event) {
        getLogger().debug("Entity Mount Event! " + event.toString());
        if(event.getTargetEntity().getType() == EntityTypes.RIDEABLE_MINECART) {
            RideableMinecart cart = (RideableMinecart) event.getTargetEntity();
            cart.setSwiftness(this.getMaxSwiftness());
        }
    }
    
    /**
     * TODO: Have commands to register lol
     */
    private void registerCommands() {
        
    }
}
