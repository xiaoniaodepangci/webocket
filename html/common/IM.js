
window.IM = {
    socket: null,
    token: '',
    init: function (token, onOpen) {
        IM.token = token
        if (window.WebSocket) {
            if (IM.socket !== null &&
                IM.socket !== undefined &&
                IM.socket.readyState === WebSocket.OPEN) {
                return false
            }
            IM.socket = new WebSocket(window.wsConfig.wsPort + "?token=" + this.token);
            IM.socket.onopen = onOpen
            IM.socket.onclose = IM.onClose
            IM.socket.onerror = IM.onError
            IM.socket.onmessage = IM.onMessage
        } else {

        }
    },
    send: function (msg) {
        if (IM.socket !== null &&
            IM.socket !== undefined &&
            IM.socket.readyState === WebSocket.OPEN) {
            IM.socket.send(msg);
        } else {
            IM.init(this.token, onOpen, onClose, onMessage, onError);
        }
    },
    onOpen: function (e) {
        console.log("kaiqi")

        // setInterval("IM.keepAlive()", 10000)

    },
    onClose: function (e) {

    },
    onError: function (e) {

    },
    onMessage: function (e) {


    },
    keepAlive() {
        let type = messageType.MESSAGE_TYPE_HEART_BEAT
        let messagePayload = new MessagePayload("", "", "", type)
        IM.send(JSON.stringify(messagePayload))
    }
}

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
    MESSAGE_TYPE_HEART_BEAT: "heartBeat",
    MESSAGE_TYPE_NORMAL: "normal",
    MESSAGE_TYPE_BROADCAST: "broadcast"
}
