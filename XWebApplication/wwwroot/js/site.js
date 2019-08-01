function xondragstart(ev, key) {
    ev.dataTransfer.setData("this", key);
}
function xondrop(ev, target) {
    ev.preventDefault();
    var key = ev.dataTransfer.getData("this");
    if (key != null) {
        if (target != null) {
            target.value = key;
        }
    }
}
function xondragover(ev) {
    ev.preventDefault();
}