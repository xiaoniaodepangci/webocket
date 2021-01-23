function commonAjax(url, data, type, serialize, async, contentType) {
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

function resolveUrl(url) {
    if (url.indexOf('http') !== -1) {
        return url
    }
    return wsConfig.httpPort + url
}

function checkToken() {
    commonAjax("/token/check?token=" + localStorage.getItem("token")).then((res) => {
        if (!res.check) {
            location.href = "./index.html"
            localStorage.removeItem("token")
        }
    })
}
