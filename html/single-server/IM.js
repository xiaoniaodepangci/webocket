window.IM = {
    socket: null,
    init: function () {
        if (window.WebSocket) {
            if (IM.socket !== null &&
                IM.socket !== undefined &&
                IM.socket.readyState === WebSocket.OPEN) {
                return false
            }
            IM.socket = new WebSocket(window.wsConfig.wsPort);
            IM.socket.onopen = IM.onOpen
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
            IM.init();
        }
    },
    onOpen: function (e) {
        setInterval("IM.keepAlive()", 10000)
    },
    onClose: function (e) {

    },
    onError: function (e) {

    },
    onMessage: function (e) {

    },
    keepAlive() {
        IM.send("heartBeat")
    }
}
