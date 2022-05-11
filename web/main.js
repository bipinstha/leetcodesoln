let $main = (function () {

    function onPageLoad() {
        console.log('::onPageLoad::')
    }

    return {
        init() {
            onPageLoad();
        }
    }

})();

$main.init();