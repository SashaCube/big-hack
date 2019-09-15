package com.cubesoft.oleksandr.havryliuk.big_hack.data.JsonParse;

import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Answer;
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Mark;
import com.cubesoft.oleksandr.havryliuk.big_hack.remote.Mapper;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class AnswerParse implements Mapper<Answer> {

    @Override
    public String toJson(@NotNull Answer inst) {
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
    public Answer fromJson(@NotNull String json) {
        try{
            JSONObject o = new JSONObject(json);
            return new Answer(
                    o.getString("id"),
                    o.getString("taskId"),
                    o.getString("classId"),
                    o.getString("studentId"),
                    o.getString("body")
            );
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
