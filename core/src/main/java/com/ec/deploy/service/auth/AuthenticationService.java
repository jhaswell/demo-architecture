package com.ec.deploy.service.auth;

import java.util.UUID;

import com.ec.deploy.model.auth.User;

public interface AuthenticationService
{

    public User authenticate(String tenantName, String username) throws AuthenticationException;

    public static class AuthenticationException extends RuntimeException {
        private String username;
        private String tenantName;

        public AuthenticationException(
            String message,
            String tenantName,
            String username)
        {
            super(message);
            this.tenantName = tenantName;
            this.username = username;
        }

        public String getTenantName()
        {
            return tenantName;
        }

        public void setTenantName(String tenantName)
        {
            this.tenantName = tenantName;
        }

        public String getUsername()
        {
            return username;
        }

        public void setUsername(String username)
        {
            this.username = username;
        }


    }
}
