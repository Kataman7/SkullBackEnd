package main.domain.model;

import javax.json.JsonObject;

public interface Model {
    JsonObject toJson();
}
