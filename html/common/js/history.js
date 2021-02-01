import {isNotNull} from '../common.js'

/**
 * 设置聊天历史
 *
 * @param {string} curr 当前账号
 * @param {string} other 对方账号
 * @param {string} content 内容
 * @param {string} flag 是谁发送的 other别人发送的， mine自己发送的
 */
export function setHistory(curr, other, content, flag) {
    let key = "chat" + curr + "-" + other;

    let chatHistoryListStr = localStorage.getItem(key);
    let chatHistoryList;
    if (isNotNull(chatHistoryListStr)) {
        chatHistoryList = JSON.parse(chatHistoryListStr)
    } else {
        chatHistoryList = [];
    }
    let singleMsg = new ChatHistory(curr, other, content, flag);
    chatHistoryList.push(singleMsg);
    localStorage.setItem(key, JSON.stringify(chatHistoryList));
}
/**
 * 设置聊天历史
 *
 * @param {string} curr 当前账号
 * @param {string} other 对方账号
 */
export function getHistory(curr, other) {
    var key = "chat" + curr + "-" + other;
    var chatHistoryListStr = localStorage.getItem(key);
    var chatHistoryList;
    if (isNotNull(chatHistoryListStr)) {
        chatHistoryList = JSON.parse(chatHistoryListStr)
    } else {
        chatHistoryList = [];
    }
    return chatHistoryList;
}

export class ChatHistory {
    /**
     * 聊天历史类
     *
     * @param {string} curr 当前账号
     * @param {string} other 对方账号
     * @param {string} content 内容
     * @param {string} flag 是谁发送的 other别人发送的， mine自己发送的
     */
    constructor(curr, other, content, flag) {
        this.curr = curr;
        this.other = other;
        this.content = content;
        this.flag = flag;
    }
}
