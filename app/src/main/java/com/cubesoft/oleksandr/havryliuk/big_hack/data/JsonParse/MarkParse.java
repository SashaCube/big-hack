package com.cubesoft.oleksandr.havryliuk.big_hack.data.JsonParse;

import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Mark;
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Task;
import com.cubesoft.oleksandr.havryliuk.big_hack.remote.Mapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;


public class MarkParse implements Mapper<Mark> {

    @Override
    public String toJson(@NotNull Mark inst) {
        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = null;
        try {
            jsonStr = Obj.writeValueAsString(inst);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return jsonStr;
    }

    @Override
    public Mark fromJson(@NotNull String json) {
        try{
            JSONObject o = new JSONObject(json);
            return new Mark(
                    o.getString("id"),
                    o.getString("taskId"),
                    o.getString("classId"),
                    o.getString("studentId"),
                    o.getString("teacherId"),
                    o.getString("body")
            );
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
