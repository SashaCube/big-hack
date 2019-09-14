package com.cubesoft.oleksandr.havryliuk.big_hack.remote;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.bloqly.api.BloqlyClient;
import com.bloqly.api.KeyPair;
import com.bloqly.api.transaction.SignedTransaction;
import com.bloqly.api.transaction.Transaction;
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Answer;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class Test {

    public void main() {
        Answer an = new Answer("13", "1", "2","3", "TestBody");
        testTransaction(an);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void testTransaction(Answer answer) {
        String privateKey = "giwyrQcDYhudVrSjdKLgp44YwyD/nl3F1AnO0KKeJTo=";
        String publicKey = "sveQDMN3Fdzi0Yvm3bhkyu0uT/08wQfymhXqD0GT4vU=";
        String space = "space1";
        String key = "key1";

        BloqlyClient bloqlyClient = new BloqlyClient("http://10.4.32.17:8082");

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
        tx.setMemo("Ihor`s test transaction");
        tx.setTimestamp(Instant.now().toEpochMilli());
        tx.setValue(answer.getBody());

        List<String> tags = new ArrayList<>();
        tags.add(answer.getId());
        tags.add(answer.getClassId());
        tags.add(answer.getTaskId());
        tags.add(answer.getSubjectId());
        tx.setTags(tags);

        SignedTransaction signedTx = keyPair.signTransaction(tx);

        bloqlyClient.submitTransaction(signedTx);
    }
}
