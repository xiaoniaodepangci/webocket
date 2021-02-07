import {isNotNull} from "../common.js";

export function loadSnapShot() {

}
export function saveSnapShot(username, sender, msg, isRead) {
    var me = this;
    var key = "chat_snapshot_" + username;
    var snapShotListStr = localStorage.getItem(key);
    var snapShotList;
    if (isNotNull(chatSnapshotListStr)) {
        snapShotList = JSON.parse(chatSnapshotListStr)
        for (var i = 0; i < chatSnapshotList.length; i++) {
            if (chatSnapshotList[i].sender === sender) {
                //删除已存在的frienduserName对应的对象
                chatSnapshotList.splice(i, 1);
                break;
            }
        }

    } else {
        snapShotList = [];
    }
    var singleMsg = new me.ChatSnapshot(myUserName, friendUserName, msg, isRead);
    chatSnapshotList.unshift(singleMsg);
    localStorage.setItem(key, JSON.stringify(chatSnapshotList));
}
class SnapShot {
    /**
     * @param sender 发送者
     * @param receiver 接收者
     * @param content 消息体
     * @param isRead 是否已读
     * */
    constructor(sender, receiver, content, isRead) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.isRead = isRead;
    }
}