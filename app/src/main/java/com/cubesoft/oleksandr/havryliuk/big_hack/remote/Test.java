package com.cubesoft.oleksandr.havryliuk.big_hack.remote;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.bloqly.api.BloqlyClient;
import com.bloqly.api.KeyPair;
import com.bloqly.api.transaction.SignedTransaction;
import com.bloqly.api.transaction.Transaction;


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
        List<String> tags = new ArrayList<String>();

        tags.add("Thisiscustomtag3");
        tags.add("Thisiscustomtag2");
        tags.add("Thisiscustomtag1");


        sighnAndSendTransaction(privateKey,space,key,tags,"This is memo2","EMPTY VAL");
    }

    public Test(){
        bloqlyClient = new BloqlyClient("http://10.4.32.17:8082");
    }

    public void sendTask(String task){

    }

    public void sighnAndSendTransaction(String privateKey, String space,
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

/*      List<String> tags = new ArrayList<>();
        tags.add("tag1");
        tags.add("tag2");*/


        SignedTransaction signedTx = keyPair.signTransaction(tx);

        bloqlyClient.submitTransaction(signedTx);
    }




}
