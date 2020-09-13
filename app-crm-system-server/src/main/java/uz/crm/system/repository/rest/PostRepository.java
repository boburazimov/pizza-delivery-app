package uz.crm.system.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import uz.crm.system.entity.catalogs.Post;
import uz.crm.system.repository.rest.projection.CustomPost;

import java.util.UUID;

@CrossOrigin
@RepositoryRestResource(path = "post", collectionResourceRel = "list", excerptProjection = CustomPost.class)
public interface PostRepository extends JpaRepository<Post, UUID> {
}
