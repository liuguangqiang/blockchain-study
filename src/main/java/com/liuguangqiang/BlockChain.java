package com.liuguangqiang;

import java.util.ArrayList;
import java.util.List;

public class BlockChain {

    /**
     * 当前节点的区块链结构
     */
    private List<Block> blocks;

    /**
     * 初始化区块链, 并且生成创世块
     */
    public BlockChain() {
        blocks = new ArrayList<Block>();
        blocks.add(Block.newBlock("Genesis Block", ""));
    }

    public void addBlock(String data) {
        blocks.add(Block.newBlock(data, getLast().getHash()));
    }

    public Block getLast() {
        return blocks.get(blocks.size() - 1);
    }

    public List<Block> getBlocks() {
        return blocks;
    }
}
