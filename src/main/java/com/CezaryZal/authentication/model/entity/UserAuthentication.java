package com.CezaryZal.authentication.model.entity;

import com.CezaryZal.authentication.model.ObjectToAuthResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users_auth")
@Getter
@NoArgsConstructor
@SqlResultSetMapping(
        name="ResultToAuthResponse",
        classes = {
                @ConstructorResult(
                        targetClass = ObjectToAuthResponse.class,
                        columns = {
                                @ColumnResult(name="id", type = Long.class),
                                @ColumnResult(name="password", type = String.class),
                                @ColumnResult(name="roles", type = String.class)
                        })
        })
@NamedNativeQuery(
        name = "query_to_handle_login_endpoint",
        query = "select users_auth.password, users_auth.roles, user.id from users_auth, user " +
                "where users_auth.id = user.users_auth_id AND user.login_name =:loginName",
        resultSetMapping = "ResultToAuthResponse"
)
public class UserAuthentication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private boolean active;

    @Column(name = "roles")
    private String roles;

    @Column(name = "permissions")
    private String permissions;

    public void setId(Long id) {
        this.id = id;
    }


    public static final class Builder{
        private Long id;
        private String password;
        private boolean active;
        private String roles;
        private String permissions;

        public static Builder builder(){
            return new Builder();
        }

        public Builder id(Long id){
            this.id = id;
            return this;
        }
        public Builder password(String password){
            this.password = password;
            return this;
        }
        public Builder active(boolean active){
            this.active = active;
            return this;
        }
        public Builder roles(String roles){
            this.roles = roles;
            return this;
        }
        public Builder permissions(String permissions){
            this.permissions = permissions;
            return this;
        }

        public UserAuthentication build(){
            UserAuthentication userAuthentication = new UserAuthentication();
            userAuthentication.id = this.id;
            userAuthentication.password = this.password;
            userAuthentication.active = this.active;
            userAuthentication.roles = this.roles;
            userAuthentication.permissions = this.permissions;
            return userAuthentication;
        }
    }
}
