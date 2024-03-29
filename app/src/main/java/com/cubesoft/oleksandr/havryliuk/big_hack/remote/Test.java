package com.cubesoft.oleksandr.havryliuk.big_hack.remote;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.bloqly.api.BloqlyClient;
import com.bloqly.api.KeyPair;
import com.bloqly.api.transaction.SignedTransaction;
import com.bloqly.api.transaction.Transaction;
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Answer;
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Mark;
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Task;

import java.util.UUID;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RequiresApi(api = Build.VERSION_CODES.O)
public class Test {


    public static final String TEATCHER = "TEATCHER";
    public static final String SUBJECT = "SUBJECT";
    public static final String STUDENT = "STUDENT";
    public static final String TASK = "TASK";
    public static final String ANSWER = "ANSWER";
    public static final String CLASS = "CLASS";


    String privateKey = "giwyrQcDYhudVrSjdKLgp44YwyD/nl3F1AnO0KKeJTo=";
    String publicKey = "sveQDMN3Fdzi0Yvm3bhkyu0uT/08wQfymhXqD0GT4vU=";
    String space = "space1";
    String key = "key1";
    BloqlyClient bloqlyClient;


    public void main(){
        Task task = new Task(UUID.randomUUID().toString(),"HomeWork",publicKey,"MyClass","Mathematics","VALUE OF THE TASK");
        sendTask(task);
    }

    public Test(){
        bloqlyClient = new BloqlyClient("http://10.4.32.17:8082");
    }

    public void sendTask(Task task){
        List<String> tags = new ArrayList<>();
        tags.add(TEATCHER + task.getTeacherId());
        tags.add(task.getId());
        tags.add(CLASS+task.getClassId());
        signAndSendTransaction(privateKey,space,key,tags,
                "TASK created for class: "+task.getClassId()+" \nTaskName -> " + task.getName(),
                task.getBody());
    }

    public void sendMark(Mark mark){
        List<String> tags = new ArrayList<>();
        tags.add(TEATCHER+mark.getTeacherId());
        tags.add(CLASS+mark.getClassId());
        tags.add(TASK+mark.getTaskId());
//        tags.add(mark.getUserID());
//        tags.add(mark.getAnswerID());
        tags.add(mark.getId());
        signAndSendTransaction(privateKey,space,key,tags,
                "MARK created for: "+mark.getClassId()+"\nby teatcher-> " + mark.getTeacherId(),
                mark.getBody());
    }

    public void signAndSendTransaction(String privateKey, String space,
                         String key, List<String> tags, String memo, String value){

        Optional<SignedTransaction> txOpt = bloqlyClient.getLastTransaction(space, key);

        Long nonce = (Long) txOpt.map(new Function<SignedTransaction, Object>() {
            @Override
            public Object apply(SignedTransaction tx) {
                return tx.getNonce() + 1;
            }
        }).orElse(1L);

        KeyPair keyPair = KeyPair.fromPrivateKeyEncoded(privateKey);

        Transaction tx = new Transaction();

        tx.setSpace(space);
        tx.setKey(key);
        tx.setNonce(nonce);
        tx.setMemo(memo);
        tx.setTimestamp(Instant.now().toEpochMilli());
        tx.setValue(value);
        tx.setTags(tags);



        SignedTransaction signedTx = keyPair.signTransaction(tx);

        bloqlyClient.submitTransaction(signedTx);
    }




}
