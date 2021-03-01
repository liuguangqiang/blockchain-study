package com.liuguangqiang;

public class Client {

    public static void main(String[] args) {
        BlockChain blockChain = new BlockChain();
        blockChain.addBlock("测试某某币1");
        blockChain.addBlock("测试某某币2");
        for (Block block : blockChain.getBlocks()) {
            System.out.println("Prev Hash:" + block.getPrevBlockHash());
            System.out.println("Hash:" + block.getHash());
            System.out.println("Data:" + block.getData());
            System.out.println("");
        }
    }
}
