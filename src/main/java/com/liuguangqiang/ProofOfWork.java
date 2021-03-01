package com.liuguangqiang;

import java.math.BigInteger;

public class ProofOfWork {

    /**
     * 难度目标值
     * <p>
     * 设定一个难度目标位TARGET_BITS，表示最终挖矿挖出来Hash值，转化为二进制后，与256相比，长度少了多少bit，也即二进制前面有多少bit是零.
     */
    private static final int targetBits = 20;

    private Block block;

    public ProofOfWork(Block block) {
        this.block = block;
    }

    public void run() {
        System.out.println("开始挖矿...");
        //对1进行移位运算，将1向左移动 (256 - TARGET_BITS) 位，得到我们的难度目标值
        BigInteger target = BigInteger.valueOf(1).shiftLeft(256 - targetBits);
        int nonce = 0;
        String hash = null;
        while (nonce < Long.MAX_VALUE) {
            hash = Utils.SHA256(prepareData(nonce));
            if (new BigInteger(hash, 16).compareTo(target) == -1) {
                System.out.println("挖矿成功...");
                break;
            } else {
                nonce++;
            }
        }
        block.setHash(hash);
        block.setNonce(nonce);
    }

    private String prepareData(int nonce) {
        String header = block.getPrevBlockHash()
                + block.getData()
                + block.getTimestamp()
                + targetBits
                + nonce;
        return header;
    }
}
