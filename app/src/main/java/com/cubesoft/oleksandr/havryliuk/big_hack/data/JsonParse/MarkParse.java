package com.cubesoft.oleksandr.havryliuk.big_hack.data.JsonParse;

import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Mark;
import com.cubesoft.oleksandr.havryliuk.big_hack.remote.Mapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;


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
        ObjectMapper mapper = new ObjectMapper();
        try{
            return mapper.readValue(json, Mark.class);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
