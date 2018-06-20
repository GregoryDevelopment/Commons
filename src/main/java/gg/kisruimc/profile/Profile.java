package gg.kisruimc.profile;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
public class Profile
{

    @Getter
    private static Map<UUID, Profile> profiles = new HashMap<>();

    private UUID uuid;
    private String name;

    public Profile(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;

        profiles.put(uuid, this);
    }

    public static Profile getByUuid(UUID uuid) {
        return profiles.get(uuid);
    }
}
