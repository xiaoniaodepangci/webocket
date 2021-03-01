class MessagePayload {
    /**
     * @param sender 发送者
     * @param receiver 接收者
     * @param content 消息体
     * @param type 消息类型
     * */
    constructor(sender, receiver, content, type) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.type = type;
    }
}

var messageType = {
    /**
     * 心跳消息
     */
    MESSAGE_TYPE_HEART_BEAT: "heartBeat",
    /**
     * 普通消息
     */
    MESSAGE_TYPE_NORMAL: "normal",
    /**
     * 广播消息
     */
    MESSAGE_TYPE_BROADCAST: "broadcast"
}
