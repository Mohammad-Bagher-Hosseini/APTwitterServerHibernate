package entities.server;

import java.io.Serializable;

public enum RespondCode implements Serializable
{
    SUCCESS,
    FAIL,
    UNKNOWN,
    INVALID_OBJECT,
    INVALID_COMMAND,
}
