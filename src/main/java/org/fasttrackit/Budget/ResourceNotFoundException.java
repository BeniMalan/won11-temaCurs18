package org.fasttrackit.Budget;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException{
    private final long entityID;

    public ResourceNotFoundException(String message, long entityID) {
        super ( message );
        this.entityID = entityID;
    }

}

