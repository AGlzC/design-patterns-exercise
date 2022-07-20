package oop.inheritance.data.terminals.Verifone;

import oop.library.ingenico.model.Transaction;
import oop.library.ingenico.model.TransactionResponse;

import java.io.*;

public class Converter {

    public TransactionResponse byteArrayToTransactionResponse(byte[] byteArray)
    {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
        ObjectInput inputObject;
        TransactionResponse response;
        try {
            inputObject = new ObjectInputStream(byteArrayInputStream);
            response = (TransactionResponse) inputObject.readObject();
            inputObject.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    public byte[] transactionToByteArray(Transaction transaction)
    {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream);
            outputStream.writeObject(transaction);
            outputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
