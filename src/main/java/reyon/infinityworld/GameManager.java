package reyon.infinityworld;

import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class GameManager implements Listener {
    @EventHandler
    public void spawn(EntitySpawnEvent e){
        if(!(e.getEntity() instanceof Monster)) return;
        Monster monster= ((Monster) e.getEntity());
        Location entitySpawnlocation=e.getEntity().getLocation().clone();
        Location worldSpawnLocation=e.getEntity().getWorld().getSpawnLocation().clone();
        entitySpawnlocation.setY(0);
        worldSpawnLocation.setY(0);
        int strength= (int) (entitySpawnlocation.distance(worldSpawnLocation)/100);
        monster.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(monster.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue()+strength);
        monster.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(monster.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getDefaultValue()+strength);
        monster.setCustomName("Lv."+strength);
    }
}
