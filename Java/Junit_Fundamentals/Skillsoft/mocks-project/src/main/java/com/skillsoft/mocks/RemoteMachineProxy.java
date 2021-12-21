package com.skillsoft.mocks;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Note: Assume that is is a proxy that uses a URL to connect to another machine
//and allows us to perform operations on the other machine.


public class RemoteMachineProxy {

    private final String remoteUrl;
    private Iterator<String> remoteFileOperator;

    public RemoteMachineProxy(String remoteUrl) {
        this.remoteUrl = remoteUrl;
    }

    private void connect() {
        //Note: Assume this connects to the remote machine and initializes
        //an iterator to get the list of records stored in the remote machine
    }

    void setTestIterator(Iterator<String> testIterator) {
        this.remoteFileOperator = testIterator;
    }

    public String getNextFile() {
        if(remoteFileOperator.hasNext()) {
            String record = remoteFileOperator.next();

            Matcher m = Pattern
                    .compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+")
                    .matcher(record);

            if(m.find()) {
                return m.group();
            }

            return remoteFileOperator.next();
        }
        return null;
    }

}
