function delFunction(fid) {
    if (confirm('是否确认删除？')) {
        window.location.href = 'delete?fid=' + fid;
    }

}

function pageFunction(pageNo) {
    window.location.href = 'index?pageNo=' + pageNo;
}