
function WebSocketConnection(url) {
    this.potions = {url: url}

    this.socket = null
    this.token = ''
    this.send = () => {
    }
    this.onOpen = () => {
    }
    this.onClose = () => {
    }
    this.onError = () => {
    }
    this.onMessage = () => {
    }
    // this.reconnect()
    // 心跳
    // this.keepAlive = function () {
    //     let type = MessageType.MESSAGE_TYPE_HEART_BEAT
    //     let messagePayload = new MessagePayload("", "", "", type)
    //     this.socket.send(JSON.stringify(messagePayload))
    // }
    this.connectionBuild()
}

// 创建socket连接
WebSocketConnection.prototype.connectionBuild = function () {
    try {
        this.socket = new WebSocket(this.potions.url);
        this.initHandleMethod()
    } catch (e) {
        throw e
    }
}
// 初始化websocket事件回调
WebSocketConnection.prototype.initHandleMethod = function () {
    this.socket.onopen = () => {
        this.onOpen();
        // this.keepAlive()
    }
    this.socket.close = () => {
        this.onClose()
    }
    this.socket.onerror = () => {
        this.onError()
    }
    this.socket.onmessage = (e) => {
        this.onMessage(e)
    }
}
WebSocketConnection.prototype.send = function(msg) {
    this.socket.send(msg);
};

if (window) {
    window.WebSocketConnection = WebSocketConnection
}

