import {isNotNull, getCurrUserInfo, getFriendInfo} from "../common.js";
import {chatIngPage} from "./friend.js";

const key_per = 'chat_snapshot_'

/**
 * 构建单个聊天快照的dom
 *
 * @param item 单个聊天快照的数据
 * @returns {string}
 */
function snapShotListHtmlBuilder(item) {

    let friend = getFriendInfo(item.friendUsername)

    let domHtml = '<div class="friendItemBox" username="' + item.friendUsername + '">' +
        '    <div class="avatar">' +
        '        <img src="' + item.friendProfile + '" alt="">' +
        '    </div>' +
        '    <div class="nameAndMsg">' +
        '        <div class="nickname">' + friend.nickname + '</div>' +
        '        <div class="snapshot">' +
        '            <div class="content">' + item.content + '</div>'
    let readable = '<span class="layui-badge-dot"></span>'
    let end = '        </div>' +
        '    </div>' +
        '</div>';
    if (item.isRead) {
        return domHtml + end
    } else {
        return domHtml + readable + end
    }
}

export function loadSnapShot(dom) {
    let username = getCurrUserInfo().username;
    let snapshotList = getUserChatSnapshot(username)
    let snapShotListHtml = "";
    let $_dom = $(dom)
    $_dom.empty();
    for (let i = 0; i < snapshotList.length; i++) {
        let item = snapshotList[i];
        console.log(JSON.stringify(item));
        snapShotListHtml = snapShotListHtmlBuilder(item)
        $_dom.prepend(snapShotListHtml);
    }

    $_dom.unbind().on("click", ".friendItemBox", function (e) {
        let nickname = $(this).find(".nickname").html();
        let username = $(this).attr("username");
        parent.layer.open({
            title: nickname,
            type: 2,
            area: ['600px', '450px'],
            fixed: false, //不固定
            maxmin: true,
            anim: 5,
            isOutAnim: false,
            content: [chatIngPage, 'no'],
            end: () => {
                localStorage.removeItem("currChatIng")
            }
        });
        localStorage.setItem("currChatIng", username)
    });
}

/**
 * 保存聊天快照
 *
 * @param username 当前登录用户
 * @param friendUsername 好友的username
 * @param msg 消息体
 * @param isRead 消息是否被读取
 * @param friendProfile 发送者头像
 */
export function saveSnapShot(username, friendUsername, msg, isRead, friendProfile) {
    let key = key_per + username;
    let snapShotListStr = localStorage.getItem(key);
    let snapShotList;
    if (isNotNull(snapShotListStr)) {
        snapShotList = JSON.parse(snapShotListStr)
        for (let i = 0; i < snapShotList.length; i++) {
            if (snapShotList[i].friendUsername === friendUsername) {
                // 删除已存在的friendUsername对应的对象
                snapShotList.splice(i, 1);
                break;
            }
        }

    } else {
        snapShotList = [];
    }
    let singleMsg = new SnapShot(username, friendUsername, msg, isRead, friendProfile);
    snapShotList.unshift(singleMsg);
    localStorage.setItem(key, JSON.stringify(snapShotList));
}

/**
 * 获取当前登录用户的聊天快照即消息列表
 *
 * @param username
 * @returns {*[]}
 */
export function getUserChatSnapshot(username) {
    let key = key_per + username;
    let snapShotListStr = localStorage.getItem(key);
    let snapShotList;
    if (isNotNull(snapShotListStr)) {
        snapShotList = JSON.parse(snapShotListStr)
    } else {
        snapShotList = [];
    }
    return snapShotList;
}


class SnapShot {
    /**
     * @param username 当前登录用户
     * @param friendUsername 好友的username
     * @param content 消息体
     * @param isRead 是否已读
     * @param friendProfile 好友的头像
     * */
    constructor(username, friendUsername, content, isRead, friendProfile) {
        this.username = username;
        this.friendUsername = friendUsername;
        this.content = content;
        this.isRead = isRead;
        this.friendProfile = friendProfile;
    }
}