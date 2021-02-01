/**
 * 公共请求方法
 *
 * @param {*} url 请求地址
 * @param {any} data 数据
 * @param {string} type 请求类型
 * @param {boolean} serialize 是否格式化为json
 * @param {boolean} async 是否异步
 * @param {null} contentType 设置contentType 当type为post时不设定 其他情况自定
 */
export function commonAjax(url, data, type, serialize, async, contentType) {
    if (contentType === undefined || contentType === null) {
        contentType = "application/json; charset=utf-8"
    }
    if (type === undefined || type === null) {
        type = "GET"
    }
    if (async === undefined || async === null) {
        async = true
    }
    return $.ajax({
        contentType: contentType,
        headers: {
            token: localStorage.getItem("token")
        },
        type: type,
        dataType: "json",
        async: true,
        url: resolveUrl(url),
        data: serialize === true ? JSON.stringify(data) : data
    })
}

// 地址匹配
export function resolveUrl(url) {
    if (url.indexOf('http') !== -1) {
        return url
    }
    return wsConfig.httpPort + url
}

//  token检查
export function checkToken() {
    commonAjax("/token/check?token=" + localStorage.getItem("token")).then((res) => {
        if (!res.check) {
            location.href = "./index.html"
            localStorage.removeItem("token")
        }
    })
}

// 本地保存好友列表
export function setFriendInfos(list) {
    localStorage.setItem("friends", JSON.stringify(list))
}

// 获取好友列表（本地）
export function getFriendInfos() {
    return JSON.parse(localStorage.getItem("friends"))
}

// 获取好友信息
export function getFriendInfo(username) {

    let list = JSON.parse(localStorage.getItem("friends"));

    list.filter(item => {
        return item.username === username
    })
    return list[0]
}

// 获取当前用户信息
export function getCurrUserInfo() {
    return JSON.parse(localStorage.getItem("currUserInfo"))
}

// 字符串判断是否为空的
export function isNotNull(str) {
    return str != null && str !== "" && str !== undefined;
}
