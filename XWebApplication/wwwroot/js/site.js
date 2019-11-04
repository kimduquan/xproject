const XRATIO = (1 + Math.sqrt(5)) / 2;

function xequation(a, b, c) {
    var res = new Object();
    if (a + b + c == 0) {
        res.x1 = 1;
        res.x2 = c / a;
    }
    else if (a - b + c == 0) {
        res.x1 = -1;
        res.x2 = -1 * c / a;
    }
    else {
        var delta = b * b - 4 * a * c;
        res.x1 = 0;
        res.x2 = 0;
        if (delta > 0) {
            res.x1 = (-1 * b + Math.sqrt(delta)) / (2 * a);
            res.x2 = (-1 * b - Math.sqrt(delta)) / (2 * a);
        }
        else if (delta == 0) {
            res.x1 = -1 * b / (2 * a);
            res.x2 = x1;
        }
    }
    return res;
}

function xratio(small, big, smaller = true) {
    var xratio = XRATIO;
    var multiple = small * big;
    var newMultiple = 0;
    if (smaller)
        newMultiple = multiple / xratio;
    else
        newMultiple = multiple * xratio;

    var a = xratio;
    var b = 0;
    var c = -1 * newMultiple;
    var equation = xequation(a, b, c);
    var out = new Object();
    out.newSmall = equation.x1;
    out.newBig = equation.x2;
    out.newBig = out.newSmall * xratio;
    return out;
}

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

function xratioForm(formClass, cssClass) {
    var form = document.querySelector("form." + formClass);
    if (form != null) {
        var labelSize = 0;
        var inputSize = 0;
        var divs = form.querySelectorAll("div." + cssClass);
        for (var i = 0; i < divs.length; i++) {
            var div = divs[i];
            var label = div.querySelector("label." + cssClass);
            var input = div.querySelector("input." + cssClass);
            if (label != null) {
                if (label["size"] > labelSize) {
                    labelSize = label["size"];
                }
            }
            if (input != null) {
                if (input["size"] > inputSize) {
                    inputSize = input["size"];
                }
            }
        }
        var size = xratio(labelSize, inputSize, false);
        for (var i = 0; i < divs.length; i++) {
            var div = divs[i];
            var label = div.querySelector("label." + cssClass);
            var input = div.querySelector("input." + cssClass);
            if (label != null && input != null) {
                label["size"] = size.newSmall;
                input["size"] = size.newBig;
            }
        }
    }
}

function xonload(ev) {
    xratioForm("constructor-info", "parameter-info");
    xratioForm("method-info", "parameter-info");
}