package com.codecentric.retailbank.model.security;

public class Role {

    //region FIELDS
    private Long id;

    private String name;
    //endregion

    //region CONSTRUCTORS
    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    //endregion

    //region GETTERS / SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //endregion

    //region OVERRIDES
    @Override public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Role role = (Role) obj;
        return role.equals(role.name);
    }

    @Override public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Role [name=").append(name).append("]").append("[id=").append(id).append("]");
        return builder.toString();
    }
    //endregion
}
