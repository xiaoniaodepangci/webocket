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
        type: type,
        dataType: "json",
        async: true,
        url: url,
        data: serialize === true ? JSON.stringify(data) : data
    })
}
