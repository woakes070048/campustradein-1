package me.ifeify.infrastructure.entity;

import com.google.common.base.MoreObjects;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

/**
 * @author ifeify
 */
@Entity("user_profile")
@Indexes({
        @Index(value = "user_id", fields = @Field("userId"), options = @IndexOptions(unique = true)),
        @Index(value = "user_name", fields = @Field("username"), options = @IndexOptions(unique = true)),
        @Index(value = "email_address", fields = @Field("email"), options = @IndexOptions(unique = true))
})
public class UserProfile {
    @Id
    private ObjectId id;
    private String userId;
    private String username;
    private String email;
    private String password;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("userId", userId)
                .add("username", username)
                .add("email", email)
                .add("password", password)
                .toString();
    }
}
