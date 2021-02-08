import {getFriendInfos, setFriendInfos, commonAjax} from "../common.js";
// 正在聊天的页面
export const chatIngPage = './chating.html'

/**
 * 获取好友数据并生成好友列表
 * @param dom
 */
export function builderFriendHtml(dom) {
    let friendInfos = getFriendInfos();
    if (friendInfos === undefined || friendInfos === null) {
        commonAjax('/myFriends/').then((res) => {
            console.log(res.list);
            let list = res.list;
            let html = ''
            if (list.length !== 0) {
                list.forEach(item => {
                    html += friendListHtmlBuilder(item)
                })
                $("#friendList").empty().html($(html))
            }
            setFriendInfos(list)
        })
    } else {
        if ($(dom)) {
            let html = ''
            friendInfos.forEach(item => {
                html += friendListHtmlBuilder(item)
            })
            $(dom).empty().html($(html))
        }
    }
    $(dom).unbind().on("click", ".friendItemBox", function (e) {
        var nickname = $(this).find(".nickname").html();
        var username = $(this).attr("username");
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
 * 构建单个好友信息的dom
 *
 * @param item 好友信息
 * @returns {string}
 */
function friendListHtmlBuilder(item) {
    return '<div class="friendItemBox" username="' + item.username + '">' +
        '    <div class="avatar">' +
        '        <img src="' + item.profile + '" alt="">' +
        '    </div>' +
        '    <div class="nameAndMsg">' +
        '        <div class="nickname">' + item.nickname + '</div>' +
        '        <div class="snapshot">' +
        '        </div>' +
        '    </div>' +
        '</div>';
}
