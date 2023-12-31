function loadPage(href) {

    if(href == '') {
        $('#content').load('./pages/ds_entry/ds_entry.html');
    } else {
        $('#content').load('./pages/' + href);
    }
}

window.addEventListener('hashchange', function () {
    let href = location.hash.substring(1);
    loadPage(href);
});

window.dispatchEvent(new Event('hashchange'));

function loadModule(url) {
    var timestamp = Date.now();
    var scriptUrl = `${url}?timestamp=${timestamp}`;
    var scriptElement = document.createElement("script");
    scriptElement.type = "module";
    scriptElement.src = scriptUrl;
    document.head.appendChild(scriptElement);
}