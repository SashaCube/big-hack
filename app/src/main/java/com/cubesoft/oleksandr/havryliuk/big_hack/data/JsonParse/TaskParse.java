package com.cubesoft.oleksandr.havryliuk.big_hack.data.JsonParse;

import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Task;
import com.cubesoft.oleksandr.havryliuk.big_hack.remote.Mapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class TaskParse implements Mapper<Task> {

    @Override
    public String toJson(@NotNull Task inst) {
        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = null;
        try {
            jsonStr = Obj.writeValueAsString(inst);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

    @Override
    public Task fromJson(@NotNull String json) {
        try {
            JSONObject o = new JSONObject(json);
            return new Task(
                    o.getString("id"),
                    o.getString("name"),
                    o.getString("teacherId"),
                    o.getString("classId"),
                    o.getString("subjectId"),
                    o.getString("body")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
