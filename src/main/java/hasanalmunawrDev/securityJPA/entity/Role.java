package hasanalmunawrDev.securityJPA.entity;

public enum Role {
    OWNER,
    ADMIN,
    MANAGER,
    STAFF;

    // Access the role name directly:
    public String getName() {
        return this.name(); // Use enum's built-in name() method
    }
}
