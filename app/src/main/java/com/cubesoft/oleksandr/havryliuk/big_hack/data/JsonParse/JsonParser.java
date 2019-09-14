package com.cubesoft.oleksandr.havryliuk.big_hack.data.JsonParse;

import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Answer;
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Mark;
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Task;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.jetbrains.annotations.NotNull;

public class JsonParser{

    public static Answer parseToAnswer(String json)
    {
        ObjectMapper mapper = new ObjectMapper();
        try{
            return mapper.readValue(json, Answer.class);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Mark parseToMark(String json)
    {
        ObjectMapper mapper = new ObjectMapper();
        try{
            return mapper.readValue(json, Mark.class);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Task parseToTask(String json)
    {
        ObjectMapper mapper = new ObjectMapper();
        try{
            return mapper.readValue(json, Task.class);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
