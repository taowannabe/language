var config = [
    "https://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"
];

function initConfig(config) {
    if (typeof config == "array") {
        config.array.forEach(function(element) {
            document.writeln("<script type=\"text/javascript\" src=\"" + element + "\"/>");
        }, this);
    }
};

initConfig(config);