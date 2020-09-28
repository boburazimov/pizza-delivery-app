package uz.crm.system.repository.rest.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.crm.system.entity.catalogs.Post;
import uz.crm.system.entity.enums.UserStatusEnum;

import java.util.UUID;

@Projection(name = "customPost", types = Post.class)
public interface CustomPost {

    UUID getId();

    String getName();

    UserStatusEnum getStatus();
}
