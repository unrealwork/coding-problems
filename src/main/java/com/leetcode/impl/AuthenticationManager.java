package com.leetcode.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

final class AuthenticationManager {
    private final Map<String, Integer> storage;
    private int timeToLive;

    AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.storage = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        this.storage.putIfAbsent(tokenId, currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        Integer tokenStartTime = storage.get(tokenId);
        if (tokenStartTime != null && tokenStartTime + timeToLive < currentTime) {
            storage.put(tokenId, currentTime);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        Iterator<Map.Entry<String, Integer>> it = storage.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> kv = it.next();
            if (kv.getValue() + timeToLive <= currentTime) {
                it.remove();
            } else {
                count++;
            }
        }
        return count;
    }
}
