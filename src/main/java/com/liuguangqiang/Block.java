package com.liuguangqiang;

public class Block {

    private String hash;

    private String prevBlockHash;

    private String data;

    private long timestamp;

    private int nonce;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPrevBlockHash() {
        return prevBlockHash;
    }

    public void setPrevBlockHash(String prevBlockHash) {
        this.prevBlockHash = prevBlockHash;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    private Block(String data, String prevBlockHash) {
        this.data = data;
        this.prevBlockHash = prevBlockHash;
        this.timestamp = System.currentTimeMillis() / 1000;
    }

    public static Block newBlock(String data, String prevBlockHash) {
        Block block = new Block(data, prevBlockHash);
        ProofOfWork proofOfWork = new ProofOfWork(block);
        proofOfWork.run();
        return block;
    }
}