package me.ifeify.infrastructure;

import me.ifeify.infrastructure.entity.UserProfile;

/**
 * @author ifeify
 */
public interface UserProfileRepository extends IdEnabledRepository<UserProfile> {
    UserProfile findByUsername(String username);
}
