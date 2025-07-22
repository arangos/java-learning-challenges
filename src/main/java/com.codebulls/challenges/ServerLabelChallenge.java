package com.codebulls.challenges;

import java.util.*;

public class ServerLabelChallenge {

        /*
        (UpWork challenge)
        Physical servers used by our project are labeled using printed labels, with exactly one label
        being attached to a server at any given time. Each label consists of an alphabetic host type (e.g.
        "apibox") concatenated with the server number, with server numbers allocated sequentially (so,
        the first label will be "apibox:1", next one "apibox:2", etc). As servers are provisioned and
        deprovisioned, the labels get attached and detached; detached labels can later be reused for
        the same host type.

        We would like to keep the total number of labels printed to a minimum (we’re environmentally
        friendly!). We would also like to maintain sequential numbering to the extent possible, so when
        we need a label, we always pick the one with the lowest number.
        Your task is to write a label tracking class with two operations, "attach(hostType)" and
        "detach(label)". The former should return the next label to use, while the latter should return the
        label back into the pool.

        For example:
        const tracker = new Tracker();
        tracker.attach("apibox");
        >> "apibox:1"
        tracker.attach("apibox");
        >> "apibox:2"
        tracker.detach("apibox:1");
        tracker.attach("apibox");
        >> "apibox:1"
        tracker.attach("apibox");
        >> "apibox:3"
        tracker.detach("apibox:2");
        tracker.attach("apibox");
        >> "apibox:2"
        tracker.attach("sitebox");
        >> "sitebox:1"
        4
        3
        3
        5
        30
        4
        24
        48
     */


    public static void main(String[] args) {
        System.out.println(attach("apibox"));
        System.out.println(attach("apibox"));
        System.out.println(attach("authbox"));
        System.out.println(attach("apibox"));
        detach("apibox:3");
        detach("apibox:2");
        System.out.println(attach("apibox"));
        detach("apibox:2");
        System.out.println(attach("sitebox"));
        System.out.println(attach("authbox"));
        System.out.println(attach("apibox"));
    }

    //here we should use 2 maps one for the generation of the next value and one to get the free labels to reused them
    static Map<String, Set<Integer>> freeMap = new HashMap<>(); // the map for detached, free labels
    static Map<String, Integer> nextMap = new HashMap<>(); // the map for next number

    public static String attach(String serverName){
        Set<Integer> freeSet = freeMap.get(serverName);
        int serverNumber;
        if(freeSet != null && !freeSet.isEmpty()){
            serverNumber = Collections.min(freeSet);
            freeSet.remove(serverNumber);
        } else {
            serverNumber = nextMap.getOrDefault(serverName, 1);
            nextMap.put(serverName, serverNumber + 1);
        }
        return serverName + ":" + serverNumber;
    }

    public static void detach(String serverLabel){
        String[] slitString = serverLabel.split(":");
        var label = Integer.valueOf(slitString[1]);
        var server = freeMap.get(slitString[0]);
        if(server == null){
            Set<Integer> newSet = new HashSet<>();
            newSet.add(label);
            freeMap.put(slitString[0], newSet);
        }else{
            server.add(label);
        }
    }

}
